package com.blogapp.banner.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BannerRequest {

    @NotBlank(message = "Banner title is required")
    private String title;

    private String subtitle;

    @NotBlank(message = "Banner image URL is required")
    private String imageUrl;

    private String actionUrl;

    private Boolean active = true;

    private Integer displayOrder = 0;
}
