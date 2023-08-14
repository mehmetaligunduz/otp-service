package com.otpserivce.repository;

import com.otpserivce.entity.OtpEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OtpRepositoryImpl implements OtpRepository {

    private final Map<String, OtpEntity> codes;

    public OtpRepositoryImpl() {
        this.codes = new HashMap<>();
    }

    @Override
    public void put(String key, OtpEntity object) {
        codes.put(key, object);
    }

    @Override
    public OtpEntity get(String key) {
        return codes.get(key);
    }

    @Override
    public void clear() {

        List<String> removeItemList = new ArrayList<>();

        if (codes.isEmpty())
            return;

        codes.forEach((k, v) -> {
            if (v.isExpired())
                removeItemList.add(k);
        });

        removeItemList.forEach(codes::remove);

    }

    @Override
    public boolean contains(String code) {
        return codes
                .values()
                .stream()
                .anyMatch(x -> Boolean.TRUE.equals(x.codeIsExist(code)));
    }

}
