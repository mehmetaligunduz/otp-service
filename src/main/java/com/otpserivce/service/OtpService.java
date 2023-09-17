package com.otpserivce.service;

public interface OtpService {

    String generateCode(String owner);

    boolean verify(String owner, String code);

    void clear();

}
