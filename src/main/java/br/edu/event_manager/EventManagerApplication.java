package br.edu.event_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class EventManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(EventManagerApplication.class, args);
	}
}
