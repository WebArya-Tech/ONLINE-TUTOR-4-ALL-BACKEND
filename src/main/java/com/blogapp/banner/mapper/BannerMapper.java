package com.blogapp.banner.mapper;

import com.blogapp.banner.dto.response.BannerResponse;
import com.blogapp.banner.entity.Banner;

public class BannerMapper {

    private BannerMapper() {}

    public static BannerResponse toResponse(Banner banner) {
        return BannerResponse.builder()
                .id(banner.getId())
                .title(banner.getTitle())
                .subtitle(banner.getSubtitle())
                .imageUrl(banner.getImageUrl())
                .actionUrl(banner.getActionUrl())
                .active(banner.getActive())
                .displayOrder(banner.getDisplayOrder())
                .createdAt(banner.getCreatedAt())
                .updatedAt(banner.getUpdatedAt())
                .build();
    }
}
