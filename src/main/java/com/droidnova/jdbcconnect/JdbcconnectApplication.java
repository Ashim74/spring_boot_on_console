package com.droidnova.jdbcconnect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

@SpringBootApplication
public class JdbcconnectApplication implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {

		SpringApplication.run(JdbcconnectApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		String sql = "SELECT * FROM students";
		List<Students> students= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Students.class));
		students.forEach(System.out :: println);
	}
}
