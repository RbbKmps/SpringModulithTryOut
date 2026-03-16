package com.modulith.demo.config;

import java.nio.charset.StandardCharsets;
import java.util.Set;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Base64;

@ControllerAdvice
public class RequestDecoder extends RequestBodyAdviceAdapter {
    Logger logger = LoggerFactory.getLogger(RequestDecoder.class);

    @Override
    public boolean supports(@NonNull MethodParameter methodParameter, @NonNull Type targetType,
                            @NonNull Class<? extends HttpMessageConverter<?>> converterType) {
        var attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes != null && Set.of("POST", "PUT", "PATCH").contains(attributes.getRequest().getMethod());
    }

    @Override
    public HttpInputMessage beforeBodyRead(@NonNull HttpInputMessage inputMessage, @NonNull MethodParameter parameter,
                                           @NonNull Type targetType, @NonNull Class<? extends HttpMessageConverter<?>> converterType) throws IOException {

        return new HttpInputMessage() {
            @Override
            public InputStream getBody() throws IOException {
                byte[] encodedBytes = inputMessage.getBody().readAllBytes();
                String encodedString = new String(encodedBytes, StandardCharsets.UTF_8);
                logger.info("Incoming: {}", encodedString);

                byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
                String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
                logger.info("Successfully Decoded Payload: {}", decodedString);

                return new ByteArrayInputStream(decodedBytes);
            }

            @Override
            public HttpHeaders getHeaders() {
                return inputMessage.getHeaders();
            }
        };
    }
}