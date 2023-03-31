package br.com.correiosconsultacep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CorreiosconsultacepApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorreiosconsultacepApplication.class, args);
	}

}
