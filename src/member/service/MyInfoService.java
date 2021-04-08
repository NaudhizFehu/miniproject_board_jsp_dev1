package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class MyInfoService {

	private MemberDao memberDao = new MemberDao();

	public Member MyInfo(String id) throws SQLException {
		
		Connection conn =null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Member member = memberDao.selectById(conn,id);
			return member;
	}
		finally {
		JdbcUtil.close(conn);
		}
	}
}