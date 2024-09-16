package com.capstone.pizzastore.menu.controller;

import com.capstone.pizzastore.menu.model.ItemDetailsRequest;
import com.capstone.pizzastore.menu.model.ItemDto;
import com.capstone.pizzastore.menu.service.MenuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping("/new-item")
    public ResponseEntity<ItemDto> addItemToMenu(@RequestBody @Valid
                                                 ItemDetailsRequest itemDetailsRequest) {
        ItemDto iem = menuService.addItemToMenu(itemDetailsRequest);
        return ResponseEntity.ok(iem);
    }

    //@GetMapping("/getitems") @GetMapping("/getitem/{itemid} @DeleteMapping("/deleteitem/{itemid}") @PutMapping("/updateitem")
}
