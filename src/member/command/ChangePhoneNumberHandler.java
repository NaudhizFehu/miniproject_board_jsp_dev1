package member.command;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import member.service.ChangePhoneNumberService;
import member.service.MemberNotFoundException;
import mvc.command.CommandHandler;

public class ChangePhoneNumberHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/changePhoneNumberForm.jsp";
	private ChangePhoneNumberService changePhoneNumberSvc = new ChangePhoneNumberService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
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


	private String processSubmit(HttpServletRequest req, HttpServletResponse res)
	throws Exception {
		User user = (User)req.getSession().getAttribute("authUser");
			
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		String newPhoneNumber1 = req.getParameter("newPhoneNumber1");
		String newPhoneNumber2 = req.getParameter("newPhoneNumber2");
		String newPhoneNumber3 = req.getParameter("newPhoneNumber3");
		
		if (newPhoneNumber1 == null || newPhoneNumber1.isEmpty() ||
				newPhoneNumber2 == null || newPhoneNumber2.isEmpty() ||
				newPhoneNumber3 == null || newPhoneNumber3.isEmpty()) {
			errors.put("blankNewPhoneNumber", Boolean.TRUE);
		}
		
		checkPhoneNumber(errors, newPhoneNumber1, newPhoneNumber2, newPhoneNumber3, "notPhoneNumber");
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			changePhoneNumberSvc.changePhoneNumber(user.getId(), newPhoneNumber1, newPhoneNumber2, newPhoneNumber3);
			return "/WEB-INF/view/changePhoneNumberSuccess.jsp";

		} catch (MemberNotFoundException e) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}

	// 전화번호 양식체크
		private void checkPhoneNumber(Map<String, Boolean> errors, String value1, String value2, String value3,
				String errorName) {

			if (value1 == null || value1.isEmpty() || value2 == null || value2.isEmpty() || value3 == null
					|| value3.isEmpty())
				return;

			// 전화번호 검사용 정규식
			String regex = "^(010|011|016|017|018|019)[-\\s]?\\d{3,4}[-\\s]?\\d{4}$";

			// 전화번호 양식 검사를 위한 value합침
			String phone = value1 + "-" + value2 + "-" + value3;

			// 결과값(true|false)
			boolean result = Pattern.matches(regex, phone);

			if (!result) {
				errors.put(errorName, Boolean.TRUE);
			}
		}
}
