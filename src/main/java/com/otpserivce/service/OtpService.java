package com.otpserivce.service;

public interface OtpService {

    void generateCode(String owner);

    boolean verify(String owner, String code);

    void clear();

}
