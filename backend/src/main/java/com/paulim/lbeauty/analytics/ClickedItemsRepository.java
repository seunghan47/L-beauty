package com.paulim.lbeauty.analytics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClickedItemsRepository extends JpaRepository<ClickedItems, Long> {
}
