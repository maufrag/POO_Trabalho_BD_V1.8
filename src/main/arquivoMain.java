package main;

import java.sql.Connection;
import java.sql.SQLException;
import ConexaoBD.ConnectionFactory;


public class arquivoMain {

	public static void main(String[] args) {
		Connection con = ConnectionFactory.getConnection();
		try {
			System.out.println("Teste");
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
