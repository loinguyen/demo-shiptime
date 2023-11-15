package com.shiptime.demo.services;

import com.shiptime.demo.dto.model.RateRequest;
import com.shiptime.demo.dto.model.RateResponse;
import com.shiptime.demo.dto.model.ShipRequest;
import com.shiptime.demo.dto.model.ShipResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service("apiServices")
public class ShippingServices {

    Logger logger = LoggerFactory.getLogger(ShippingServices.class);
    private final WebClient webClientForShippingAPI;

    public ShippingServices(WebClient webClientForShippingAPI) {
        this.webClientForShippingAPI = webClientForShippingAPI;
    }

    public Mono<RateResponse> getShippingRates(RateRequest request) {
        Map<String, String> params = new HashMap<>();
        params.put("email", "loi.nguyen.01835@gmail.com");
        return webClientForShippingAPI.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/rates")
                        .build())
                .contentType(MediaType.APPLICATION_JSON)
                .body( Mono.just(request), RateRequest.class)
                .retrieve()
                .bodyToMono(RateResponse.class);
    }

    public Mono<ShipResponse> postShipments(ShipRequest request) {
        return webClientForShippingAPI.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/shipments")
                        .build())
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), ShipRequest.class)
                .retrieve()
                .bodyToMono(ShipResponse.class)
                .doOnError(exception -> {
                    logger.warn("Failed to send notification to {}, cause {}", "/rates", exception.getMessage());
                });
    }

    public Mono<byte[]> getPrintedLabel(String requestUrl) {
        Mono<byte[]> monoData = webClientForShippingAPI.get()
                .uri(requestUrl)
                .accept(MediaType.APPLICATION_PDF)
                .retrieve()
                .bodyToMono(byte[].class)
                .doOnError(exception -> {
                    logger.warn("Failed to send notification to {}, cause {}", "/rates", exception.getMessage());
                });

        return monoData;
    }
}
