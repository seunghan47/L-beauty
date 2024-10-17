package com.paulim.lbeauty.controller;

import com.paulim.lbeauty.model.Career;
import com.paulim.lbeauty.service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/career")
@CrossOrigin("*")
public class CareerController {

    @Autowired
    CareerService careerService;

    @PostMapping("/addCareer")
    public ResponseEntity<Career> addJob(@RequestBody Career career) {
        Career saved = careerService.save(career);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

}
