package com.digitalheroes.anupriya.sde.page_pulse.controller;

import com.digitalheroes.anupriya.sde.page_pulse.model.AuditRequest;
import com.digitalheroes.anupriya.sde.page_pulse.model.AuditResponse;
import com.digitalheroes.anupriya.sde.page_pulse.service.AuditService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AuditController {

    private final AuditService auditService;

    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @PostMapping("/audit")
    public ResponseEntity<AuditResponse> auditUrl(@RequestBody AuditRequest request) {
        if (request.getUrl() == null || request.getUrl().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        AuditResponse response = auditService.auditUrl(request.getUrl());
        return ResponseEntity.ok(response);
    }
}