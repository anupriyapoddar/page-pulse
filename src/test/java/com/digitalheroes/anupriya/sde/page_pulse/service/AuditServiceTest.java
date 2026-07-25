package com.digitalheroes.anupriya.sde.page_pulse.service;

import com.digitalheroes.anupriya.sde.page_pulse.model.AuditResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuditServiceTest {

    private final AuditService auditService = new AuditService();

    @Test
    void testInvalidUrlHandling() {
        // Test a malformed or completely unreachable URL to ensure it handles failures gracefully without crashing
        AuditResponse response = auditService.auditUrl("https://this-domain-definitely-does-not-exist-12345.com");

        assertNotNull(response);
        assertEquals(500, response.getHttpStatus());
    }

    @Test
    void testLocalhostOrNetworkErrorHandling() {
        // Test empty string or invalid scheme handling
        AuditResponse response = auditService.auditUrl("invalid-url-format");

        assertNotNull(response);
        assertEquals(500, response.getHttpStatus());
    }
}
