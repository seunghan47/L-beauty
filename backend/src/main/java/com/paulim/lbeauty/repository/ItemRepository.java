package com.paulim.lbeauty.repository;

import com.paulim.lbeauty.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findByName(String name);
}
