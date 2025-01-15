package com.paulim.lbeauty.service;

import com.paulim.lbeauty.model.Career;
import com.paulim.lbeauty.model.Inventory;
import com.paulim.lbeauty.repository.CareerRepository;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CareerServiceTest {

    @Mock
    private CareerRepository careerRepository;

    @InjectMocks
    private CareerService careerService;

    @Test
    void save() {
        Career param = new Career();

        param.setEmail("asdf");
        param.setName("asdf");
        param.setMessage("asdf");
        param.setPhone("asdf");

        Career response = new Career();

        response.setEmail("asdf");
        response.setName("asdf");
        response.setMessage("asdf");
        response.setPhone("asdf");

        when(careerRepository.save(param)).thenReturn(response);
        Career career = careerService.save(param);
        assertEquals(response.getName(), career.getName());
    }
}