package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import member.dao.MemberDao;
import member.model.Member;

public class ChangeEmailService {

	private MemberDao memberDao = new MemberDao();
	
	public void changeEmail(String userId,String newEmail) {
		Connection conn =null;
		try {
			conn= ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Member member = memberDao.selectById(conn, userId);
			if(member == null) {
				throw new MemberNotFoundException();
			}
			member.changeEmail(newEmail);
			memberDao.updateEmail(conn, member);
			conn.commit();
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
	}
}
