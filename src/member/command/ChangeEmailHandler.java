package member.command;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import member.service.ChangeEmailService;
import member.service.MemberNotFoundException;
import mvc.command.CommandHandler;

public class ChangeEmailHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/changeEmailForm.jsp";
	private ChangeEmailService changeEmailSvc = new ChangeEmailService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		User user = (User) req.getSession().getAttribute("authUser");

		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		String newEmail = req.getParameter("newEmail");

		if (newEmail == null || newEmail.isEmpty()) {
			errors.put("blankNewEmail", Boolean.TRUE);
		}

		checkEmail(errors, newEmail, "notEmail");

		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			changeEmailSvc.changeEmail(user.getId(), newEmail);
			return "/WEB-INF/view/changeEmailSuccess.jsp";
		} catch (MemberNotFoundException e) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}

	// 이메일 양식검사
	private void checkEmail(Map<String, Boolean> errors, String value, String errorName) {

		if (value == null || value.isEmpty())
			return;

		// 이메일 양식 정규식
		String regex = "\\w+@\\w+\\.\\w+(\\.\\w+)?";

		// 결과값
		boolean result = Pattern.matches(regex, value);

		if (result == false) {
			errors.put(errorName, Boolean.TRUE);
		}
	}
}
