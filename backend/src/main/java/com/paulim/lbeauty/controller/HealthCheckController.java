package com.paulim.lbeauty.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@CrossOrigin("*")
public class HealthCheckController {

    @GetMapping
    @Operation(
            summary = "Health Check",
            description = "Checks and returns a message to see if APIs are working"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "API is healthy"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("api is up and running");
    }
}
