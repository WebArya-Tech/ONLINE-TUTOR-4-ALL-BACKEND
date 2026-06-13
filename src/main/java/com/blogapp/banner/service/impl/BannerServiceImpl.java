package com.blogapp.banner.service.impl;

import com.blogapp.banner.dto.request.BannerRequest;
import com.blogapp.banner.dto.response.BannerResponse;
import com.blogapp.banner.entity.Banner;
import com.blogapp.banner.mapper.BannerMapper;
import com.blogapp.banner.repository.BannerRepository;
import com.blogapp.banner.service.BannerService;
import com.blogapp.common.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;

    @Override
    public BannerResponse createBanner(BannerRequest request) {
        Banner banner = Banner.builder()
                .title(request.getTitle())
                .subtitle(request.getSubtitle())
                .imageUrl(request.getImageUrl())
                .actionUrl(request.getActionUrl())
                .active(request.getActive() == null ? true : request.getActive())
                .displayOrder(request.getDisplayOrder() == null ? 0 : request.getDisplayOrder())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return BannerMapper.toResponse(bannerRepository.save(banner));
    }

    @Override
    public BannerResponse updateBanner(String id, BannerRequest request) {
        Banner banner = bannerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Banner not found with id: " + id));

        banner.setTitle(request.getTitle());
        banner.setSubtitle(request.getSubtitle());
        banner.setImageUrl(request.getImageUrl());
        banner.setActionUrl(request.getActionUrl());
        banner.setActive(request.getActive() == null ? banner.getActive() : request.getActive());
        banner.setDisplayOrder(request.getDisplayOrder() == null ? banner.getDisplayOrder() : request.getDisplayOrder());
        banner.setUpdatedAt(LocalDateTime.now());

        return BannerMapper.toResponse(bannerRepository.save(banner));
    }

    @Override
    public void deleteBanner(String id) {
        Banner banner = bannerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Banner not found with id: " + id));
        bannerRepository.delete(banner);
    }

    @Override
    public BannerResponse getBannerById(String id) {
        return bannerRepository.findById(id)
                .map(BannerMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Banner not found with id: " + id));
    }

    @Override
    public List<BannerResponse> getAllBanners() {
        return bannerRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(BannerMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<BannerResponse> getPublicBanners() {
        return bannerRepository.findByActiveTrueOrderByDisplayOrderDescCreatedAtDesc().stream()
                .map(BannerMapper::toResponse)
                .collect(Collectors.toList());
    }
}
