package article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleContentNotFoundException;
import article.service.ArticleNotFoundException;
import article.service.DeleteArticleService;
import mvc.command.CommandHandler;

public class DeleteArticleHandler implements CommandHandler{
	
	private DeleteArticleService deleteService
	= new DeleteArticleService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String noVal = req.getParameter("no");
		int articleNum = Integer.parseInt(noVal);
		
		try {
				deleteService.delete(articleNum);
				return "/WEB-INF/view/deleteArticleSuccess.jsp";
		} catch (ArticleNotFoundException e) {
				res.sendError(HttpServletResponse.SC_NOT_FOUND);
				return null;
		} catch (ArticleContentNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
}
