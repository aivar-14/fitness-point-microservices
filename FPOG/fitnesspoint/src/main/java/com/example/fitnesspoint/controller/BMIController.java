package com.example.fitnesspoint.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fitnesspoint.model.BMIRecord;
import com.example.fitnesspoint.model.User;
import com.example.fitnesspoint.repository.UserRepository;
import com.example.fitnesspoint.service.BMIService;

@Controller
@RequestMapping("/bmi")
public class BMIController {

    private final BMIService bmiService;
    private final UserRepository userRepo;

    public BMIController(BMIService bmiService, UserRepository userRepo) {
        this.bmiService = bmiService;
        this.userRepo = userRepo;
    }

    @GetMapping("/calculate")
    public String form(Model m) {
        m.addAttribute("bmiForm", new BMIForm());
        return "bmi";
    }

    @PostMapping("/calculate")
    public String calc(@ModelAttribute BMIForm bmiForm, Model m, Authentication auth) {
        String username = auth.getName();
        User user = userRepo.findByUsername(username).orElseThrow();
        BMIRecord rec = bmiService.calculateAndSave(user, bmiForm.getWeightKg(), bmiForm.getHeightCm());
        m.addAttribute("result", rec);
        m.addAttribute("history", bmiService.history(user));
        return "bmi";
    }

    public static class BMIForm {
        private double weightKg;
        private double heightCm;
        public double getWeightKg(){return weightKg;}
        public void setWeightKg(double w){this.weightKg=w;}
        public double getHeightCm(){return heightCm;}
        public void setHeightCm(double h){this.heightCm=h;}
    }
}
