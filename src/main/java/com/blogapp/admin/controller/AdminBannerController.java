package com.blogapp.admin.controller;

import com.blogapp.banner.dto.request.BannerRequest;
import com.blogapp.banner.dto.response.BannerResponse;
import com.blogapp.banner.service.BannerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/banners")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@PreAuthorize("hasRole('ADMIN')")
@Tag(name = "Admin Banner", description = "Admin endpoints for managing homepage banners")
public class AdminBannerController {

    private final BannerService bannerService;

    @PostMapping
    @Operation(summary = "Create a new homepage banner")
    public ResponseEntity<BannerResponse> createBanner(@Valid @RequestBody BannerRequest request) {
        return new ResponseEntity<>(bannerService.createBanner(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing homepage banner")
    public ResponseEntity<BannerResponse> updateBanner(@PathVariable String id,
                                                       @Valid @RequestBody BannerRequest request) {
        return ResponseEntity.ok(bannerService.updateBanner(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a homepage banner")
    public ResponseEntity<Void> deleteBanner(@PathVariable String id) {
        bannerService.deleteBanner(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Operation(summary = "List all homepage banners for admin")
    public ResponseEntity<List<BannerResponse>> getAllBanners() {
        return ResponseEntity.ok(bannerService.getAllBanners());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a single banner by id")
    public ResponseEntity<BannerResponse> getBannerById(@PathVariable String id) {
        return ResponseEntity.ok(bannerService.getBannerById(id));
    }
}
