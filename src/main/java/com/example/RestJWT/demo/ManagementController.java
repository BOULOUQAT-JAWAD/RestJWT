package com.example.RestJWT.demo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/management")
@PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
@Tag(name = "Management")
public class ManagementController {
    @Operation(
            description = "Get endpoint for manager",
            summary = "This is a summary for management get endpoint",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }

    )
    @GetMapping
    @PreAuthorize("hasAnyAuthority('admin:read','manager:read')")
    public String get() {
        return "GET:: management controller";
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('admin:create','manager:create')")
    public String post() {
        return "POST:: management controller";
    }
    @PutMapping
    @PreAuthorize("hasAnyAuthority('admin:update','manager:update')")
    public String put() {
        return "PUT:: management controller";
    }
    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('admin:delete','manager:delete')")
    public String delete() {
        return "DELETE:: management controller";
    }
}
