package com.otpserivce.service;

public interface OtpService {

    String generateCode(String owner);

    boolean verify(String owner, String code);

    String getCode(String owner);

    void clear();

}
