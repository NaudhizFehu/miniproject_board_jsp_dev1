package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import member.service.ChangePasswordService;
import member.service.InvalidPasswordException;
import member.service.MemberNotFoundException;
import mvc.command.CommandHandler;

public class ChangePasswordHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/changePwForm.jsp";
	private ChangePasswordService changePwdSvc = new ChangePasswordService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		}
		if (req.getMethod().equalsIgnoreCase("POST")) {
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

		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);

		String curPwd = req.getParameter("curPw");
		String newPwd = req.getParameter("newPw");

		if (curPwd == null || curPwd.isEmpty()) {
			errors.put("blankCurPw", Boolean.TRUE);
		}
		if (newPwd == null || newPwd.isEmpty()) {
			errors.put("blankNewPw", Boolean.TRUE);
		}

		checkPassword(errors, newPwd, "notPassword");

		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			changePwdSvc.changePassword(user.getId(), curPwd, newPwd);
			return "/WEB-INF/view/changePwSuccess.jsp";
		} catch (InvalidPasswordException e) {
			errors.put("wrongCurPw", Boolean.TRUE);
			return FORM_VIEW;
		} catch (MemberNotFoundException e) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}

	// 비밀번호 양식 체크(6~20자)
	private void checkPassword(Map<String, Boolean> errors, String value, String errorName) {

		if (value == null || value.isEmpty())
			return;

		if (value.length() < 6 || value.length() > 20) {
			errors.put(errorName, Boolean.TRUE);
		}
	}
}
