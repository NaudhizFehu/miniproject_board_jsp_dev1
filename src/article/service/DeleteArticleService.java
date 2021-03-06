package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.ArticleContent;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class DeleteArticleService {
	
	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();
	
	public void delete(int articleNum) {
			Connection conn = null;
			try {
					conn = ConnectionProvider.getConnection();
					conn.setAutoCommit(false);
					
					Article article = articleDao.selectById(conn, articleNum);
					if(article == null) {
						throw new ArticleNotFoundException();
					}
					ArticleContent content = contentDao.selectById(conn, articleNum);
					if(content == null) {
							throw new ArticleContentNotFoundException();
					}
					contentDao.delete(conn, article.getNumber());
					articleDao.delete(conn, article.getNumber());
					conn.commit();
			} catch (SQLException e) {
				JdbcUtil.rollback(conn);
				throw new RuntimeException(e);
			} finally {
				JdbcUtil.close(conn);
			}
	}
}
