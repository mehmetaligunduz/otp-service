package com.otpserivce.repository;

import com.otpserivce.entity.OtpEntity;

public interface OtpRepository {

    void put(String key, OtpEntity value);

    OtpEntity get(String key);

    void clear();

    boolean contains(String code);
}
