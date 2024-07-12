package com.ecan.teste;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Teste Ekan Beneficiário", version = "1", description = "API desenvolvida para o teste da Ekan"))
@EnableScheduling
public class BeneficiarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeneficiarioApplication.class, args);
	}

}
