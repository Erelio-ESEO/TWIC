package com.config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JDBCConfiguration {
	@Bean
	public static Connection getonnexionBDD() {
		String url = "jdbc:h2:tcp://localhost/~/test";
		String user = "thuinaxe";
		String passwd = "network";
		Connection conn = null;

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connecter");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur");
			System.exit(0);
		}
		return conn;
	}
}
