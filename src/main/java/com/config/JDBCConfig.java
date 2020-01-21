package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class JDBCConfig {
	
	
	public static String dbDriver;
	@Value("${jdbc.driver.class.name}")
	public void setDbDriver(String string) {
		dbDriver = string;
	}
	
	public static String dbConnection;
	@Value("${jdbc.connection}")
	public void setDbConnection(String string) {
		dbConnection = string;
	}
	public static String user;
	@Value("${jdbc.user}")
	public void setUser(String string) {
		user = string;
	}
	public static String password;
	@Value("${jdbc.password}")
	public void setPassword(String string) {
		password = string;
	} 
	
	static Connection connection = null;

	
	@Bean
    public static Connection getConnection(){		

		try {
			Class.forName(dbDriver);
					
			connection = DriverManager.getConnection(dbConnection ,user, password);
			//connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:13306/villes?user=phpmyadmin&password=eseo");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
    }
    
}
