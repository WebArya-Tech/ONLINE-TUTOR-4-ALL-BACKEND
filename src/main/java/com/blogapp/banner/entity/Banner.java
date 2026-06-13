package com.blogapp.banner.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "banners")
public class Banner {

    @Id
    private String id;

    private String title;

    private String subtitle;

    private String imageUrl;

    private String actionUrl;

    @Builder.Default
    private Boolean active = true;

    @Builder.Default
    private Integer displayOrder = 0;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
