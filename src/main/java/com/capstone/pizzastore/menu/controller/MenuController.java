package com.capstone.pizzastore.menu.controller;

import com.capstone.pizzastore.menu.model.ItemDetailsRequest;
import com.capstone.pizzastore.menu.model.ItemDto;
import com.capstone.pizzastore.menu.service.MenuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;
	
	@PostMapping("/new-item")
    public ResponseEntity<ItemDto> addItemToMenu(@RequestBody @Valid ItemDetailsRequest itemDetailsRequest) {
        ItemDto item = menuService.addItemToMenu(itemDetailsRequest);
        return ResponseEntity.ok(item);
    }

    @GetMapping("/getitems")
    public ResponseEntity<List<ItemDto>> getAllItems() {
        List<ItemDto> items = menuService.fetchAllItemsDetails();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/getitem/{itemid}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable Long itemid) {
        ItemDto item = menuService.fetchItemById(itemid);
        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/deleteitem/{itemid}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long itemid) {
        menuService.deleteItem(itemid);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateitem/{itemid}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable Long itemid, @RequestBody @Valid ItemDetailsRequest itemDetailsRequest) {
        ItemDto updatedItem = menuService.updateItemDetails(itemid, itemDetailsRequest);
        return ResponseEntity.ok(updatedItem);
    }
}
