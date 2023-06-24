package com.example.jazs26288nbp;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JazS26288NbpApplication {

    public static void main(String[] args) {
        SpringApplication.run(JazS26288NbpApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("NBP rates downloader")
                        .version("1.0")
                        .description("A service that gets medium rates for specified currency")
                );
    }
}
