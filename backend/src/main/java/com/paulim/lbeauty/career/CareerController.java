package com.paulim.lbeauty.career;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/career")
@CrossOrigin("*")
@Tag(name = "Career Management", description = "Endpoints for handling job submissions and inquiries")
public class CareerController {

    private final CareerService careerService;
    public CareerController(CareerService careerService) {
        this.careerService = careerService;
    }

    @Operation(summary = "Submit a job application", description = "Saves user contact info and a message to the database for hiring review.")
    @PostMapping
    public ResponseEntity<Career> addJob(@Valid @RequestBody Career career) {
        Career savedCareer = careerService.save(career);
        return new ResponseEntity<>(savedCareer, HttpStatus.CREATED);
    }

    @Operation(summary = "Get all applications", description = "Retrieves a full list of all submitted career inquiries from the database.")
    @GetMapping
    public ResponseEntity<List<Career>> getAll() {
        List<Career> careerList = careerService.getAll();
        return new ResponseEntity<>(careerList, HttpStatus.OK);
    }
}