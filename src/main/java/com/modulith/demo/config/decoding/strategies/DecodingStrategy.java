package com.modulith.demo.config.decoding.strategies;

public interface DecodingStrategy {
    boolean supports(String encodingType);
    byte[] decode(byte[] input);
}
