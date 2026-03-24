package com.paulim.lbeauty.career;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/career")
@CrossOrigin("*")
public class CareerController {

    @Autowired
    CareerService careerService;

    @PostMapping("/addCareer")
    public ResponseEntity<Career> addJob(@RequestBody Career career) {

        System.out.println("Received Career data: " + career);
        System.out.println("email : " + career.getEmail());
        System.out.println("message : " + career.getMessage());
        System.out.println("name : " + career.getName());
        System.out.println("phone : " + career.getPhone());

        Career saved = careerService.save(career);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Career>> getAll() {
        return ResponseEntity.ok(careerService.getAll());
    }
}
