package com.blogapp.banner.controller;

import com.blogapp.banner.dto.response.BannerResponse;
import com.blogapp.banner.service.BannerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public/banners")
@RequiredArgsConstructor
@Tag(name = "Public Banner", description = "Public endpoints for homepage banners")
public class PublicBannerController {

    private final BannerService bannerService;

    @GetMapping
    @Operation(summary = "Get publicly visible homepage banners")
    public ResponseEntity<List<BannerResponse>> getPublicBanners() {
        return ResponseEntity.ok(bannerService.getPublicBanners());
    }
}
