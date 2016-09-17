package br.sceweb.servico;

import java.sql.DriverManager;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

public class FabricaDeConexoes {
	
	public Connection getConnection() {
		String url = "jdbc:mysql://localhost/sceweb";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return (Connection) DriverManager.getConnection(url, "root", "alunofatec");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
