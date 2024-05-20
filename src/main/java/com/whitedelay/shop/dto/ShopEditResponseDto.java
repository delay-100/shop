package com.whitedelay.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ShopEditResponseDto {
    private long id;
    private String title;
    private String content;
    private int price;
    private String username;
}
