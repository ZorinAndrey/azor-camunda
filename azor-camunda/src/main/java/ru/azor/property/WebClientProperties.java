package ru.azor.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * Properties for web client.
 */

@ConstructorBinding
@ConfigurationProperties(prefix = "web-client")
@Data
public class WebClientProperties {

    private String keyCloakUrl;
    private Integer connectTimeout;
    private Integer readTimeout;
    private Integer writeTimeout;
    private Integer responseTimeout;
}
