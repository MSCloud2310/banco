package com.example.banco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

// https://spring.io/guides/gs/testing-web/
@SpringBootTest
@AutoConfigureMockMvc
// To clean the DB before each test
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class CuentaControllerTest {
    @Autowired
    MockMvc mvc;

    @BeforeEach
    void init() {
    }

    @Test
    void retirar() throws Exception {
        MvcResult result = mvc.perform(get("/cuenta/{id}/retirar/{cantidad}", 1, 800)).andExpect(status().isOk())
                .andReturn();
        assertEquals("200.00", result.getResponse().getContentAsString());
    }

    @Test
    void abonar() throws Exception {
        MvcResult result = mvc.perform(get("/cuenta/{id}/abonar/{cantidad}", 1, 800)).andExpect(status().isOk())
                .andReturn();
        assertEquals("1800.00", result.getResponse().getContentAsString());
    }

    @Test
    void saldo() throws Exception {
        MvcResult result = mvc.perform(get("/cuenta/{id}/saldo", 1)).andExpect(status().isOk()).andReturn();
        assertEquals("1000.00", result.getResponse().getContentAsString());
    }
}
