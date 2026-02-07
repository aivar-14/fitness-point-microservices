package com.example.fitnesspoint.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.fitnesspoint.model.BMIRecord;
import com.example.fitnesspoint.model.User;
import com.example.fitnesspoint.repository.BMIRecordRepository;

@Service
public class BMIService {
    private final BMIRecordRepository bmiRepo;

    public BMIService(BMIRecordRepository bmiRepo) {
        this.bmiRepo = bmiRepo;
    }

    public BMIRecord calculateAndSave(User user, double weightKg, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weightKg / (heightM * heightM);
        String category;
        if (bmi < 18.5)
            category = "Underweight";
        else if (bmi < 25)
            category = "Normal";
        else if (bmi < 30)
            category = "Overweight";
        else
            category = "Obese";

        BMIRecord rec = new BMIRecord();
        rec.setUser(user);
        rec.setWeightKg(weightKg);
        rec.setHeightCm(heightCm);
        rec.setBmiValue(bmi);
        rec.setCategory(category);
        rec.setCreatedAt(LocalDateTime.now());
        return bmiRepo.save(rec);
    }

    public List<BMIRecord> history(User user) {
        return bmiRepo.findByUserOrderByCreatedAtDesc(user);
    }
}
