package com.bahati.database_postgres;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class DatabasePostgresApplication implements CommandLineRunner {

	private final DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(DatabasePostgresApplication.class, args);
	}

	public DatabasePostgresApplication (final DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override

	public void run (final String... args) {
		log.info("Database" + dataSource.toString());
		JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		restTemplate.execute("SELECT 1");
	}

}
