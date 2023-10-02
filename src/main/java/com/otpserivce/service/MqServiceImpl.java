package com.otpserivce.service;

import com.otpserivce.request.MessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class MqServiceImpl implements MqService {

    private final WebClient.Builder webClientBuilder;

    @Value("${rabbitmq.publish-url}")
    public String mqPublishUrl;

    @Override
    public void publish(String owner, String code) {

        webClientBuilder.build()
                .post()
                .uri(mqPublishUrl)
                .body(BodyInserters.fromValue(new MessageRequest(code, owner)))
                .retrieve()
                .bodyToMono(Void.class)
                .block();

    }
}
