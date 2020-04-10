package com.googongmarket.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	
	static {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	@Test
	public void testConnection() {
		
		try(Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/90market?serverTimezone=Asia/Seoul&useSSL=false", 
				"user",
				"wltn9662")) {
			
			log.info(con);
			
		} catch(Exception e) {
			
			fail(e.getMessage());
			
		}
	}
}
