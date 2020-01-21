package com.config;

import java.sql.Connection;
import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class JDBCConfigurationSol1 {
	
	
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
		
		// TODO
		
		return connection;
    }
    
}
