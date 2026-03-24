package com.paulim.lbeauty.newitem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewItemRepository extends JpaRepository<NewItem, Long> {
}
