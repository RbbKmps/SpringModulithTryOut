package com.modulith.demo;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RequestDecoderTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldDecodePostRequestBody() throws Exception {
        String userJSON = """
            {
                "username": "rbbkmps",
                "email": "robbe.kemps@cegeka.com"
            }
            """;

        String encodedUser = Base64.getEncoder().encodeToString(userJSON.getBytes(StandardCharsets.UTF_8));

        mockMvc.perform(post("http://localhost:8080/user")
                        .content(encodedUser)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("rbbkmps"))
                .andExpect(jsonPath("$.email").value("robbe.kemps@cegeka.com"));
    }
}
