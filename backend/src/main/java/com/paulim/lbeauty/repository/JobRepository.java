package com.paulim.lbeauty.repository;

import com.paulim.lbeauty.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
