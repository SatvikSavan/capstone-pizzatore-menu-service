package com.capstone.pizzastore.menu.repository;

import com.capstone.pizzastore.menu.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
