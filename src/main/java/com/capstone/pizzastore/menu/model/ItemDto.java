package com.capstone.pizzastore.menu.model;

import com.capstone.pizzastore.menu.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    private Long itemId;
    private String itemName;
    private String itemDescription;
    private Category category;
    private Long price;
    private boolean isAvailable;
}
