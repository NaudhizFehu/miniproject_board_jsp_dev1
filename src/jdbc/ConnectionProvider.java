package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	// 커넥션풀에 담긴 커넥션을 가져올 수 있는 메소드 선언, static으로 하여 클래스 생성하지 않고 바로 사용
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:apache:commons:dbcp:board_dev1");
	}
}
