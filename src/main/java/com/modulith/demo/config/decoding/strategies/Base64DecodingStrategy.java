package com.modulith.demo.config.decoding.strategies;

import java.util.Base64;
import org.springframework.stereotype.Component;

@Component
public class Base64DecodingStrategy implements DecodingStrategy {
    @Override
    public boolean supports(String encodingType) {
        return "base64".equalsIgnoreCase(encodingType);
    }

    @Override
    public byte[] decode(byte[] input) {
        return Base64.getDecoder().decode(input);
    }
}
