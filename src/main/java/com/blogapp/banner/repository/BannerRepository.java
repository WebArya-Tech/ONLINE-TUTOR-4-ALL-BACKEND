package com.blogapp.banner.repository;

import com.blogapp.banner.entity.Banner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerRepository extends MongoRepository<Banner, String> {
    List<Banner> findAllByOrderByCreatedAtDesc();
    List<Banner> findByActiveTrueOrderByDisplayOrderDescCreatedAtDesc();
}
