package com.whitedelay.shop.repository;

import com.whitedelay.shop.Entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
