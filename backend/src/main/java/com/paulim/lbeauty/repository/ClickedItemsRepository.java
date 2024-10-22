package com.paulim.lbeauty.repository;

import com.paulim.lbeauty.model.ClickedItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClickedItemsRepository extends JpaRepository<ClickedItems, Long> {
}
