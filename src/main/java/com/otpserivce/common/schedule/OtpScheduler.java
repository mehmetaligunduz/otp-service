package com.otpserivce.common.schedule;

import com.otpserivce.service.OtpService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OtpScheduler {

    private final OtpService otpService;

    private static final Logger log;

    static {

        log = LoggerFactory.getLogger(OtpScheduler.class);

    }

    @Scheduled(cron = "${schedule.cron}")
    public void clearExpiredOtpCodes() {
        otpService.clear();
        log.info("Expired otp codes have cleared");
    }

}
