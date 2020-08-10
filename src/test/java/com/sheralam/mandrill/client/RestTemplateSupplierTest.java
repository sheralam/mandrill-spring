package com.sheralam.mandrill.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestTemplateSupplierTest {

    @Test
    void get() {
        assertNotNull(new RestTemplateSupplier().get());
    }
}