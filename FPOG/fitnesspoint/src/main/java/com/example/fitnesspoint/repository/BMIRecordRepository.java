package com.example.fitnesspoint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fitnesspoint.model.BMIRecord;
import com.example.fitnesspoint.model.User;

public interface BMIRecordRepository extends JpaRepository<BMIRecord, Long> {
    List<BMIRecord> findByUserOrderByCreatedAtDesc(User user);
}
