package com.otpserivce.service;

import com.otpserivce.entity.OtpEntity;
import com.otpserivce.repository.OtpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OtpServiceImpl implements OtpService {

    private final OtpRepository otpRepository;

    private static final String DECIMAL_FORMAT = "000000";

    private static final DecimalFormat decimalFormat;

    static {

        decimalFormat = new DecimalFormat(DECIMAL_FORMAT);

    }

    @Override
    public String generateCode(String owner) {
        final String code = randomCode();
        otpRepository.put(owner, new OtpEntity(owner, code));
        return code;
    }

    @Override
    public boolean verify(String owner, String code) {
        final OtpEntity otpEntity = otpRepository.get(owner);
        if (Objects.isNull(otpEntity))
            return false;
        return otpEntity.isVerified(owner, code);
    }

    @Override
    public void clear() {
        otpRepository.clear();
    }

    private String randomCode() {
        String random;
        do {
            random = decimalFormat.format(10000 + Math.random() * 999999);
        } while (otpRepository.contains(random));
        return random;
    }
}
