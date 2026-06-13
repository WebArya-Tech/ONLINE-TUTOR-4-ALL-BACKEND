package com.blogapp.banner.service;

import com.blogapp.banner.dto.request.BannerRequest;
import com.blogapp.banner.dto.response.BannerResponse;

import java.util.List;

public interface BannerService {
    BannerResponse createBanner(BannerRequest request);
    BannerResponse updateBanner(String id, BannerRequest request);
    void deleteBanner(String id);
    BannerResponse getBannerById(String id);
    List<BannerResponse> getAllBanners();
    List<BannerResponse> getPublicBanners();
}
