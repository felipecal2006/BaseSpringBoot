package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

@DisplayName("Test main application")
 class ApplicationTests {

    @InjectMocks
    Application main;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("simular el cargado del application context")
     void applicationContextTest() {
        main.main(new String[] {});
    }

}
