package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import member.dao.MemberDao;
import member.model.Member;

public class ChangePhoneNumberService {

	private MemberDao memberDao = new MemberDao();
	
	public void changePhoneNumber(String userId, String newphoneNumber1,String newphoneNumber2,String newphoneNumber3) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Member member = memberDao.selectById(conn, userId);
			if (member == null) {
				throw new MemberNotFoundException();
			}			
			member.changePhoneNumber1(newphoneNumber1);
			member.changePhoneNumber2(newphoneNumber2);
			member.changePhoneNumber3(newphoneNumber3);

			memberDao.updatePhoneNumber(conn, member);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
