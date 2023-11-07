package br.com.lab360.task360;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan("br.com.lab360.task360.data.entities")

public class Task360Application {

	public static void main(String[] args)  {
		SpringApplication.run(Task360Application.class, args);
	}
}