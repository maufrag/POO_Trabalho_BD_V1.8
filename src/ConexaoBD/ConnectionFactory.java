package ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String DRIVE = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://pootrabalhodb.cgfepgjkba1f.us-east-1.rds.amazonaws.com:3306/BancoInicial?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	// pode ocorrer alguns erros por conta do formato do horario
	private static final String USER = "poodbadmin";
	private static final String SENHA = "Prata1452";

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, SENHA);
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("Erro na conexao");
		}
	}
}
