package com.example.usuario_service.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
			version = "v1",
			title = "Práctica 1 y 2 Diplomado Cloud Native", 
			description = "Documentación de la API de Usuario Service y Estado Service", 
			contact = @Contact(
				name = "Cristian Ricardo Ortega Ramírez (Software Developer)", 
				url = "https://www.paginaspersonales.unam.mx/app/webroot/index.php/academicos/datosContacto/alias:cristianricardoortega", 
			email = "cristian.ortega@comunidad.unam.mx")))
public class OpenApiConfig {

}
