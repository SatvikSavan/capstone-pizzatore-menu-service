package com.capstone.pizzastore.menu.model;

import com.capstone.pizzastore.menu.domain.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDetailsRequest {

    @NotBlank
    private String itemName;
    @NotBlank
    private String itemDescription;
    @NotNull
    private Category category;
    @NotNull
    private Long price;
}
