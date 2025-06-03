package com.Tarining.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.info.License;


@OpenAPIDefinition(info = @Info(title = "AndroJava Tech4U",
description = "This Api is For JavaTrainee info",
summary = "Api Contains JavaTrainee Info and Its Details",
termsOfService = "Term&ConditionApploied...",
contact = @Contact(name = "DevelopBy-Sourav",
                   email = "Sourav62040814@gmail.com",
                   url = "androjavatech4u.com"
                   
                   ),
license = @License(name = "Surya License"),
version = "Api/v1"),
servers = {@Server(description = "testEnv",url = "http://localhost:8080"),
		   @Server(description = "DevEnv",url = "http://localhost:8090")

}
)
public class SwaggerConfig {
	
	

}
