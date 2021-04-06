package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.ArticleContent;
import jdbc.connection.ConnectionProvider;

public class ReadArticleForm {

	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();
	
	public ArticleData getArticle(int articleNum, boolean increaseReadCount) {
		try (Connection conn = ConnectionProvider.getConnection()){
			
			
			// article 테이블에서 지정한 번호의 Article 객체를 구한다.
			Article article = articleDao.selectById(conn, articleNum);
			// 만약에 article 게시글 데이터가 존재하지 않는다면 예외 처리 ArticleNotFoundException 익셉션을 발생시킨다.
			if (article == null) {
				throw new ArticleNotFoundException();
			}
			// article_content 테이블에서 지정한 번호의 ArticleContent 객체를 구한다.
			ArticleContent content = contentDao.selectById(conn, articleNum);

			// 만약에 article_content 게시글 내용 데이터가 존재하지 않는다면
			// 예외 처리 ArticleContentNotFoundException 익셉션을 발생시킨다.
			if (content == null) {
				throw new ArticleContentNotFoundException();
			}
			// increaseReadCount가 true 이면, 조회수를 증가시킨다.
			if (increaseReadCount) {
				articleDao.increaseReadCount(conn, articleNum);
			}
			// ArticleData 객체를 리턴한다. 
			return new ArticleData(article, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
