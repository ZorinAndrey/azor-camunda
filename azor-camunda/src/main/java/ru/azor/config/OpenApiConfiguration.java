package ru.azor.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for Open API.
 */

@Configuration
public class OpenApiConfiguration {

    /**
     * Bean configuration OpenAPI info.
     *
     * @return {@link OpenAPI}
     */
    @Bean
    public OpenAPI api() {
        return new OpenAPI()
            .info(
                new Info()
                    .title("Spring Boot with Camunda Application")
                    .version("1")
            );
    }
}
