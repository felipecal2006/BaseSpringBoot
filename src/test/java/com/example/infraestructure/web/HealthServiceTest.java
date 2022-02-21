package com.example.infraestructure.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {HealthService.class})
class HealthServiceTest {
    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("return http 200 OK  when comsume health Service")
    void returnOkWhenConsumeHealthService() throws Exception {

        final ResultActions result =
                mvc.perform(
                        get("/healthService")
                                .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                           );
        result.andExpect(status().isOk());
    }

}
