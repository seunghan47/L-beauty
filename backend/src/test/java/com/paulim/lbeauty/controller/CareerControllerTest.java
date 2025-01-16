package com.paulim.lbeauty.controller;

import com.paulim.lbeauty.model.Career;
import com.paulim.lbeauty.service.CareerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CareerControllerTest {

    @Mock
    CareerService careerService;
    @InjectMocks
    CareerController careerController;

    @Test
    void addJob() {
        Career career = new Career();
        career.setEmail("test@example.com");
        career.setMessage("Test message");
        career.setName("Test Name");
        career.setPhone("1234567890");

        Career savedCareer = new Career();
        savedCareer.setEmail("test@example.com");
        savedCareer.setMessage("Test message");
        savedCareer.setName("Test Name");
        savedCareer.setPhone("1234567890");

        when(careerService.save(career)).thenReturn(savedCareer);

        ResponseEntity<Career> response = careerController.addJob(career);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(savedCareer, response.getBody());
        verify(careerService, times(1)).save(career);
    }
}