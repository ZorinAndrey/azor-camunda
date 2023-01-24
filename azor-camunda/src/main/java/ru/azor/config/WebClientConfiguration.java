package ru.azor.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import ru.azor.property.WebClientProperties;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Configuration for web client.
 */

@Configuration
@EnableConfigurationProperties(WebClientProperties.class)
@RequiredArgsConstructor
public class WebClientConfiguration {

    private final WebClientProperties webClientProperties;

    /**
     * Bean of KeyCloak web client.
     *
     * @return {@link WebClient}
     */
    @Bean
    public WebClient keyCloakWebClient() {

        HttpClient httpClient = reactor.netty.http.client.HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, webClientProperties.getConnectTimeout())
            .responseTimeout(Duration.ofMillis(webClientProperties.getResponseTimeout())).doOnConnected(
                conn -> conn.addHandlerLast(
                    new ReadTimeoutHandler(webClientProperties.getReadTimeout(), TimeUnit.MILLISECONDS)).addHandlerLast(
                    new WriteTimeoutHandler(webClientProperties.getWriteTimeout(), TimeUnit.MILLISECONDS)));
        return WebClient.builder().baseUrl(webClientProperties.getKeyCloakUrl())
            .clientConnector(new ReactorClientHttpConnector(httpClient)).build();
    }
}
