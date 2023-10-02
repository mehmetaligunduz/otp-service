package com.otpserivce.service;

public interface MqService {

    void publish(String owner, String code);

}
