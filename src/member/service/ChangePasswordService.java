package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;
//DB���� ���� �н����庯��
public class ChangePasswordService {
	private MemberDao memberDao = new MemberDao();
	
	public void changePassword(String userId,String curPwd,String newPwd) {
		Connection conn =null;
		try {
			conn =ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			//memberDaoŬ�������� ��й�ȣ�� ������ ���� ������������
			Member member =memberDao.selectById(conn, userId);
			//��ġ�ϴ� ������ ���°��
			if(member == null) {
				throw new MemberNotFoundException();
			}
			//�н����尡 ��ġ���� ���� ���
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
