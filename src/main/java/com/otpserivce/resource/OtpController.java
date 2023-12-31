package com.otpserivce.resource;

import com.otpserivce.request.VerifyOtpRequest;
import com.otpserivce.service.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class OtpController {

    private final OtpService otpService;

    @PostMapping("/{owner}")
    public ResponseEntity<Void> generateOtp(@PathVariable("owner") String owner) {
        otpService.generateCode(owner);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/verify")
    public ResponseEntity<Boolean> verifyOtp(@RequestBody VerifyOtpRequest request) {
        boolean verify = otpService.verify(request.getOwner(), request.getCode());
        return new ResponseEntity<>(verify, HttpStatus.OK);
    }

}
