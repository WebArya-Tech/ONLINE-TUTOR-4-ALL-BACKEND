package com.blogapp.banner.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BannerResponse {
    private String id;
    private String title;
    private String subtitle;
    private String imageUrl;
    private String actionUrl;
    private Boolean active;
    private Integer displayOrder;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
