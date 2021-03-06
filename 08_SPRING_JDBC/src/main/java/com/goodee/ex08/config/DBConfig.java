package com.goodee.ex08.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement // 트랜잭션 동작을 허용합니다.


@Configuration
public class DBConfig {
	
	//Spring JDBC
	//1. DataSource를 bean으로 등록한다.
	//2. JdbcTemplete을 bean으로 등록한다.
	//	  이 때, DataSource bean이 JdbcTemplate bean의 field로 사용된다.
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("SCOTT");
		dataSource.setPassword("1111");
		return dataSource;
	}
	
	@Bean
	//JdbcTemplate는 connection같은 기능을 가짐 위에있는 dataSource setDriver같은 걸 받아서 
	//BookRepository에 @Autowired로 부를수있다.
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}
	//Spring JDBC의 Transaction 처리
	//TransactionManager를 bean으로 등록한다.
	
	@Bean
	public TransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
