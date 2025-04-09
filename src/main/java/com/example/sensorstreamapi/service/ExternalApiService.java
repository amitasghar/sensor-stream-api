package com.example.sensorstreamapi.service;

import com.example.sensorstreamapi.model.SensorData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ExternalApiService {

    private final WebClient webClient;

    public ExternalApiService(@Value("${external.api.url}") String apiUrl,
                               @Value("${external.api.token}") String token) {
        this.webClient = WebClient.builder()
                .baseUrl(apiUrl)
                .defaultHeader("Authorization", "Bearer " + token)
                .build();
    }

    public void sendSensorData(SensorData data) {
        webClient.post()
                .body(Mono.just(data), SensorData.class)
                .retrieve()
                .bodyToMono(String.class)
                .doOnSuccess(response -> System.out.println("Successfully sent to external API."))
                .doOnError(error -> System.err.println("Failed to send to external API: " + error.getMessage()))
                .subscribe();
    }
}
