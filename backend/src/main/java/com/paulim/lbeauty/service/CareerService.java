package com.paulim.lbeauty.service;

import com.paulim.lbeauty.model.Career;
import com.paulim.lbeauty.repository.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
