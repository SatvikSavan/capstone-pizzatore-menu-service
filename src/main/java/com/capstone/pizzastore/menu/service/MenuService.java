package com.capstone.pizzastore.menu.service;

import com.capstone.pizzastore.menu.domain.Item;
import com.capstone.pizzastore.menu.model.ItemDetailsRequest;
import com.capstone.pizzastore.menu.model.ItemDto;
import com.capstone.pizzastore.menu.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final ItemRepository itemRepository;

    public List<ItemDto> fetchAllItemsDetails() {

        List<Item> items = itemRepository.findAll();
        return items.stream().map(item -> ItemDto.builder()
                .itemId(item.getItemId())
                .itemName(item.getItemName())
                .itemDescription(item.getItemDescription())
                .price(item.getPrice())
                .isAvailable(item.isAvailable())
                .build()).collect(Collectors.toList());
    }

    public ItemDto addItemToMenu(ItemDetailsRequest itemDetailsRequest) {

        Item item = Item.builder()
                .itemName(itemDetailsRequest.getItemName())
                .itemDescription(itemDetailsRequest.getItemDescription())
                .price(itemDetailsRequest.getPrice()).category(itemDetailsRequest.getCategory())
                .isAvailable(true)
                .build();
        Item updatedItem = itemRepository.save(item);
        return ItemDto.builder().itemId(updatedItem.getItemId())
                .itemName(updatedItem.getItemName())
                .itemDescription(updatedItem.getItemDescription())
                .price(updatedItem.getPrice())
                .isAvailable(updatedItem.isAvailable()).build();
    }

    public ItemDto fetchItemById(Long itemId) {
        Optional<Item> optionalItem = itemRepository.findById(itemId);
        if (optionalItem.isEmpty()) {
            return ItemDto.builder().build();
        } else {
            Item item = optionalItem.get();
            return ItemDto.builder().itemId(item.getItemId())
                    .itemName(item.getItemName())
                    .itemDescription(item.getItemDescription())
                    .price(item.getPrice())
                    .isAvailable(item.isAvailable()).build();
        }
    }

    public ItemDto updateItemDetails(Long itemId, ItemDetailsRequest itemDetailsRequest) {
        Optional<Item> optionalItem = itemRepository.findById(itemId);
        if (optionalItem.isEmpty()) {
            return null;
        } else {
            Item item = optionalItem.get();
            item.setItemDescription(itemDetailsRequest.getItemDescription());
            item.setItemName(itemDetailsRequest.getItemName());
            item.setPrice(itemDetailsRequest.getPrice());
            Item updatedItem = itemRepository.save(item);
            return ItemDto.builder().itemId(updatedItem.getItemId())
                    .itemName(updatedItem.getItemName())
                    .itemDescription(updatedItem.getItemDescription())
                    .price(updatedItem.getPrice())
                    .isAvailable(updatedItem.isAvailable()).build();
        }
    }

    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
