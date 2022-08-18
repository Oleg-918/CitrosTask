package com.oleg.document.flow.document;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class DocumentFlowApplication {

	public static void main(String[] args) {
		log.info("Прилоложение было запущено!");
		SpringApplication.run(DocumentFlowApplication.class, args);
	}

}
