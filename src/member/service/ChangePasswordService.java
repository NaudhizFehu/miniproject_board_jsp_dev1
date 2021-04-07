package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;
//DB에서 유저 패스워드변경
public class ChangePasswordService {
	private MemberDao memberDao = new MemberDao();
	
	public void changePassword(String userId,String curPwd,String newPwd) {
		Connection conn =null;
		try {
			conn =ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			//memberDao클래스에서 비밀번호를 변경할 유저 정보를가져옴
			Member member =memberDao.selectById(conn, userId);
			//일치하는 유저가 없는경우
			if(member == null) {
				throw new MemberNotFoundException();
			}
			//패스워드가 일치하지 않을 경우
			if(!member.matchPassword(curPwd)) {
				throw new InvalidPsswordException();
			}
			member.changePassword(newPwd);
			memberDao.updatePassword(conn, member);
			conn.commit();
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
	}
}
