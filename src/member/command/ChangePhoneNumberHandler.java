package member.command;

import java.util.HashMap;
import java.util.Map;

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
		
		if (newPhoneNumber1 == null || newPhoneNumber1.isEmpty()) {
			errors.put("blankNewPhoneNumber", Boolean.TRUE);
		}
		if (newPhoneNumber2 == null || newPhoneNumber2.isEmpty()) {
			errors.put("blankNewPhoneNumber", Boolean.TRUE);
		}
		if (newPhoneNumber3 == null || newPhoneNumber3.isEmpty()) {
			errors.put("blankNewPhoneNumber", Boolean.TRUE);
		}		
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

}
