package com.generation.cadu.configuration;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {
	
	@Bean
	OpenAPI springCaduOpenAPI() {
		
		return new OpenAPI()
				.info(new Info()
						.title("Projeto E-Commerce CADU") 
						.description("E-Commerce CADU - Projeto Integrador para o Bootcamp FullStack Java - Generation<br><br>"
								+ "Desenvolvedores:<br>" 
								+ "Weida Viana - winnyweida@hotmail.com<br>" 
								+ "João Pedro Guimarães - joaopedro.jusus@gmail.com<br>"
								+ "Yanca Dantas - yanca.d@live.com<br>" 
								+ "Felipe Porto - fe2017li@gmail.com<br>" 
								+ "Isabelly Dornelas - isabelly.dornelas123@gmail.com<br>"
								+ "Will Belcari - willbelcari13@gmail.com<br>"
								+ "Gustavo Oliveira - gustavo.oliver456@gmail.com")
						.version("v0.0.1")
						.license(new License()
								.name("Generation Brasil")
								.url("https://brazil.generation.org/")))
				.externalDocs(new ExternalDocumentation()
						.description("Github")
						.url("https://github.com/joaopguima/Project_Loja_Cadu"));
	}

	@Bean
	OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {
		
		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations()
					.forEach(operation -> {
						
						ApiResponses apiResponses = operation.getResponses();
						
						apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
						apiResponses.addApiResponse("201", createApiResponse("Objeto persistido!"));
						apiResponses.addApiResponse("204", createApiResponse("Objeto excluído!"));
						apiResponses.addApiResponse("400", createApiResponse("Erro na requisição!"));
						apiResponses.addApiResponse("401", createApiResponse("Acesso Não Autorizado!"));
						apiResponses.addApiResponse("403", createApiResponse("Acesso Proibido!"));
						apiResponses.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
						apiResponses.addApiResponse("500", createApiResponse("Erro na Aplicação!"));
						
					}));
		};
	}
	
	private ApiResponse createApiResponse(String message) {
		
		return new ApiResponse().description(message);
	}
}
