package com.whitedelay.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ShopListResponseDto {
    private long id;
    private String title;
    private String username;
    private int price;
}
