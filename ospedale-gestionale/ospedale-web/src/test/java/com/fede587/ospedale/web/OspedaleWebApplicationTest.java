package com.fede587.ospedale.web;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

class OspedaleWebApplicationTest {

    @Test
    void main_runs_withoutStartingRealContext() {
        try (MockedStatic<SpringApplication> mocked = Mockito.mockStatic(SpringApplication.class)) {
            mocked.when(() -> SpringApplication.run(OspedaleWebApplication.class, new String[]{}))
                  .thenReturn(Mockito.mock(ConfigurableApplicationContext.class));

            assertDoesNotThrow(() -> OspedaleWebApplication.main(new String[]{}));
        }
    }

    @Test
    void constructor_covered() {
        new OspedaleWebApplication();
    }
}
