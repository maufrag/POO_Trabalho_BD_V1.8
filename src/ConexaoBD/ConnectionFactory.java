package ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String DRIVE = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://192.168.1.144:3306/teste?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";	
	//pode ocorrer alguns erros por conta do formato do horario
	private static final String USER = "root";
	private static final String SENHA = "PooAdmin";
	
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, SENHA);
		} catch(SQLException e) {
			System.out.println(e);
			throw new RuntimeException("Erro na conexao");
		}
	}
}
