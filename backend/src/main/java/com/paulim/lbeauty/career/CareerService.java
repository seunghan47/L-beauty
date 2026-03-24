package com.paulim.lbeauty.career;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerService {

    private final CareerRepository careerRepository;

    @Autowired
    public CareerService(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
    }

    public Career save(Career career) {
        return careerRepository.save(career);
    }
    public List<Career> getAll() {
        return careerRepository.findAll();
    }
}
