package com.fede587.ospedale.web.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

class GlobalExceptionHandlerTest {

    @Test
    void handleNoSuchElement_returns404() {
        GlobalExceptionHandler h = new GlobalExceptionHandler();
        ResponseEntity<String> r = h.handleNoSuchElement(new NoSuchElementException("x"));
        assertEquals(404, r.getStatusCode().value());
        assertEquals("Not found", r.getBody());
    }

    @Test
    void handleIllegalState_returns400() {
        GlobalExceptionHandler h = new GlobalExceptionHandler();
        ResponseEntity<String> r = h.handleIllegalState(new IllegalStateException("bad"));
        assertEquals(400, r.getStatusCode().value());
        assertEquals("bad", r.getBody());
    }
}
