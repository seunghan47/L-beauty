package com.paulim.lbeauty.analytics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClickedItemRepository extends JpaRepository<ClickedItem, Long> {
}
