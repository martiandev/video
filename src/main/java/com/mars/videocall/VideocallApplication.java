package com.mars.videocall;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mars.videocall.user.User;
import com.mars.videocall.user.UserService;

@SpringBootApplication
public class VideocallApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideocallApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
		UserService service
	){
		return args -> {
			service.register(User.builder()
				.username("mars")
				.email("mraraullo@gmail.com")
				.password("12345")
				.build()
			);
			service.register(User.builder()
				.username("mars2")
				.email("mraraullo2@gmail.com")
				.password("12345")
				.build()
			);
		};
	}

}
