package com.paulim.lbeauty.shared;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("L Beauty API")
                        .version("1.0")
                        .description("Backend services for L Beauty Supply retail application.")
                        .contact(new Contact().name("Paul Lim").email("paulslim47@gmail.com")));
    }
}