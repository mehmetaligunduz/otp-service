package com.otpserivce.entity;

import lombok.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@AllArgsConstructor
public class OtpEntity {

    private String owner;

    private String code;

    private LocalDateTime createdAt;

    public OtpEntity() {
        this.createdAt = LocalDateTime.now();
    }

    public OtpEntity(String owner, String code) {
        this.owner = owner;
        this.code = code;
        this.createdAt = LocalDateTime.now();
    }

    public boolean isExpired() {
        return Math.abs(ChronoUnit.SECONDS.between(createdAt, LocalDateTime.now())) > 120;
    }

    public boolean codeIsExist(String code) {
        return this.code.equals(code);
    }

    public boolean isVerified(String owner, String code) {
        return this.owner.equals(owner) && this.code.equals(code) && Boolean.FALSE.equals(isExpired());
    }

}
