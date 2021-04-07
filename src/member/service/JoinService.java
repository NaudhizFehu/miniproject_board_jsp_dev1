package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import member.dao.MemberDao;
import member.model.Member;

public class JoinService {

	private MemberDao memberDao = new MemberDao();

	// JoinRequestŬ�������� ȸ�����Խ� �ʿ��� �������� �����ͼ� MemberDaoŬ������ �ִ� insert�޼���� DB�� ����������߰�
	public void join(JoinRequest joinReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			Member member = memberDao.selectById(conn, joinReq.getId());
			if (member != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicationException();
			}
			memberDao.insert(conn,
					new Member(joinReq.getId(), joinReq.getName(), joinReq.getPassword(), new Date(),
							joinReq.getEmail(), joinReq.getPhoneNumber1(), joinReq.getPhoneNumber2(),
							joinReq.getPhoneNumber3()));
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
