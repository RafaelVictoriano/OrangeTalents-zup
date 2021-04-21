package br.com.zup.orange.zup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class ZupApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZupApplication.class, args);
	}

}
