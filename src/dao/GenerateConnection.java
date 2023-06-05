package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenerateConnection {

	public static Connection conexao = null;
	
	public static Connection getConexao() throws SQLException {
		
		if(conexao == null) {
			
			String dbURL = "jdbc:postgresql://localhost:5432/minesolutions";
			String username = "postgres";
			String password = "@JoaoVictor10";
			
			GenerateConnection.conexao = DriverManager.getConnection(dbURL, username, password);
			
		}
		
		return conexao;
		
	}
	
}











