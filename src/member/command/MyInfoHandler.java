package member.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import member.dao.MemberDao;
import member.model.Member;
import member.service.InvalidPasswordException;
import member.service.MemberNotFoundException;
import member.service.MyInfoService;
import mvc.command.CommandHandler;

public class MyInfoHandler implements  CommandHandler{

	private static final String FORM_VIEW="/WEB-INF/view/MyInfoForm.jsp";
	private MyInfoService MyInfoService = new MyInfoService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		User user = (User)req.getSession().getAttribute("authUser");
		MyInfoService.MyInfo(user.getId());
		req.setAttribute("user",user);
		return FORM_VIEW;
	}
	
}

	

