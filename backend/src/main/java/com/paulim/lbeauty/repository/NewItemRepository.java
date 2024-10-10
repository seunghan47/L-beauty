package com.paulim.lbeauty.repository;

import com.paulim.lbeauty.model.NewItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewItemRepository extends JpaRepository<NewItem, Long> {
}
