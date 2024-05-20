package com.whitedelay.shop.controller;

import com.whitedelay.shop.dto.*;
import com.whitedelay.shop.service.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class ShopController {
    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("")
    public ShopCreateResponseDto postShop(@RequestBody ShopRequestDto shopRequestDto) {
        return shopService.postShop(shopRequestDto);
    }

    @GetMapping("")
    public List<ShopListResponseDto> getShopList() {
        return shopService.getShopList();
    }

    @PutMapping("/{id}")
    public ShopEditResponseDto updateShop(@PathVariable("id") Long id, @RequestBody ShopRequestDto shopRequestDto) {
        return shopService.updateShop(id, shopRequestDto);
    }

    @DeleteMapping("/{id}")
    public ShopDeleteResponseDto deleteShop(@PathVariable("id") Long id) {
        return shopService.deleteShop(id);
    }

}
