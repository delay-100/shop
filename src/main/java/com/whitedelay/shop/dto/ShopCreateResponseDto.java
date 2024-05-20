package com.whitedelay.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ShopCreateResponseDto {
    private long id;
    private String username;
    private String title;
    private String content;
    private int price;
}
