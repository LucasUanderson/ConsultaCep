package br.com.correiosconsultacep.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Consulta Endereço via CEP Wipro")
                        .version("31.3.23")
                        .description("API REST de consulta de endereço e cálculo de frete para\n" +
                                "um determinado CEP")
                        .termsOfService("**")
                        .license(
                                new License()
                                        .name("Apache 2.0")
                                        .url("**")
                        )
                );
    }
}
