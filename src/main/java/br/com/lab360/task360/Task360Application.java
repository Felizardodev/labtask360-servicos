package br.com.lab360.task360;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.lab360.task360.feature.User")
@EntityScan(basePackages = {"br.com.lab360.task360.feature.User", "br.com.lab360.task360.feature.Anexo", "br.com.lab360.task360.feature.Quadro"})

public class Task360Application {

	public static void main(String[] args)  {
		SpringApplication.run(Task360Application.class, args);
	}
}