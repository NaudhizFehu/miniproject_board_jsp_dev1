package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.Member;

public class MemberDao {
	// DB에서 찾는 id의 멤버정보를 불러올때 활용하는 메서드
	public Member selectById(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from member where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			Member member = null;
			if (rs.next()) {
				member = new Member(rs.getString("id"), rs.getString("name"), rs.getString("password"), 
						toDate(rs.getTimestamp("regdate")),
						rs.getString("email"), rs.getString("phoneNumber1"), rs.getString("phoneNumber2"),
						rs.getString("phoneNumber3"));
			}
			return member;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

	}
	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}


	// DB에 멤베 데이터 넣을때 쓰는 메서드
	public void insert(Connection conn, Member mem) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("insert into member values(?,?,?,?,?,?,?,?)")) {
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getName());
			pstmt.setString(3, mem.getPassword());
			pstmt.setTimestamp(4, new Timestamp(mem.getRegDate().getTime()));
			pstmt.setString(5, mem.getEmail());
			pstmt.setString(6, mem.getPhoneNumber1());
			pstmt.setString(7, mem.getPhoneNumber2());
			pstmt.setString(8, mem.getPhoneNumber3());
			pstmt.executeUpdate();
		}
	}
	//패스워드 변경시 sql문
	public void updatePassword(Connection conn,Member member) throws SQLException{
		try(PreparedStatement pstmt =conn.prepareStatement(
				"update member set password=? where id=?")){
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getId());
			pstmt.executeUpdate();
		}
	}
	public void updateEmail(Connection conn,Member member) throws SQLException{
		try(PreparedStatement pstmt =conn.prepareStatement(
				"update member set email=? where id=?")){
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getId());
			pstmt.executeUpdate();
		}
	}
	
	public void updatePhoneNumber(Connection conn,Member member) throws SQLException{
		try(PreparedStatement pstmt =conn.prepareStatement(
				"update member set phoneNumber1=?,phoneNumber2=?,phoneNumber3=? where id=?")){
			pstmt.setString(1, member.getPhoneNumber1());
			pstmt.setString(2, member.getPhoneNumber2());
			pstmt.setString(3, member.getPhoneNumber3());
			pstmt.setString(4, member.getId());
			
			pstmt.executeUpdate();
		}
	}

}
