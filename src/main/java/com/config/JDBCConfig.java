package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.mysql.jdbc.Driver;

@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class JDBCConfig {
	
	
	
	public static String url;
	@Value("${jdbc.url}")
	public void setUrl(String string) {
		url = string;
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
	
	@Bean
    public static Connection getConnection(){		

		Connection connection = null;
		
		try {
			DriverManager.registerDriver(new Driver());
			//connection = DriverManager.getConnection(url + "?user=" + user + "&password=" + password);
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:13306/villes?user=phpmyadmin&password=eseo");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
    }
    
}
