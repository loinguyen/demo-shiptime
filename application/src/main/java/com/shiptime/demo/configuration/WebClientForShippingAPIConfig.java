package com.shiptime.demo.configuration;

import io.netty.handler.logging.LogLevel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Configuration
public class WebClientForShippingAPIConfig {

    @Value("${demo.shiptime.auth.username}")
    private String username;
    @Value("${demo.shiptime.auth.password}")
    private String password;
    @Bean
    public ReactorClientHttpConnector reactorClientHttpConnector() {
        String encodedCredentials = Base64.getEncoder().encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8));

        HttpClient httpClient = HttpClient.create()
            .followRedirect((req, res) -> {
                // This condition ensures we are only following redirects from the same host
                return req.resourceUrl().equals(res.responseHeaders().get("Location"));
            })
            .doOnRequest((req, connection) -> {
                req.requestHeaders().add("Authorization", "Basic " + encodedCredentials);
            })
            .wiretap("reactor.netty.http.client.HttpClient",
                    LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL);

        return new ReactorClientHttpConnector(httpClient);
    }

    @Bean
    public WebClient.Builder webClientBuilder(ReactorClientHttpConnector reactorClientHttpConnector) {
        return WebClient.builder().clientConnector(reactorClientHttpConnector);
    }

    @Bean
    public WebClient webClientForShippingAPI(WebClient.Builder builder) {

        return builder
                .baseUrl("https://restapi.appspaces.ca/rest")
                .defaultHeaders(header -> header.setBasicAuth(username, password))
                .build();
    }
}