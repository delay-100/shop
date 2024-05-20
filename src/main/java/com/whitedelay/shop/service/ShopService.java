package com.whitedelay.shop.service;

import com.whitedelay.shop.Entity.Shop;
import com.whitedelay.shop.dto.*;
import com.whitedelay.shop.repository.ShopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public ShopCreateResponseDto postShop(ShopRequestDto shopRequestDto) {
        Shop shop = shopRepository.save(new Shop(shopRequestDto.getTitle(), shopRequestDto.getContent(), shopRequestDto.getPrice(), shopRequestDto.getUsername()));

        return new ShopCreateResponseDto(shop.getId(), shop.getUsername(), shop.getTitle(), shop.getContent(), shop.getPrice());
    }

    public List<ShopListResponseDto> getShopList() {
        List<ShopListResponseDto> shopResponseDtoList = new ArrayList<>();
        List<Shop> shops = shopRepository.findAll();

        shops.stream().toList().forEach(shop -> {
            shopResponseDtoList.add(new ShopListResponseDto(shop.getId(), shop.getTitle(), shop.getUsername(),shop.getPrice()));
        });

        return shopResponseDtoList;
    }

    @Transactional
    public ShopEditResponseDto updateShop(Long id, ShopRequestDto shopRequestDto) {
        Shop shop = shopRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id에 해당하는 글이 없습니다."));

        shop.setTitle(shopRequestDto.getTitle());
        shop.setContent(shopRequestDto.getContent());
        shop.setPrice(shopRequestDto.getPrice());
        shop.setUsername(shopRequestDto.getUsername());

        return new ShopEditResponseDto(shop.getId(), shop.getTitle(), shop.getContent(), shop.getPrice(), shop.getUsername());
    }

    public ShopDeleteResponseDto deleteShop(Long id) {
        Shop shop = shopRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id에 해당하는 글이 없습니다."));
        shopRepository.delete(shop);

        return new ShopDeleteResponseDto("삭제완료");
    }
}
