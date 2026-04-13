package com.paulim.lbeauty.inventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InventoryServiceTest {

    @Mock
    private InventoryRepository inventoryRepository;

    @InjectMocks
    private InventoryService inventoryService;

    private Inventory sampleItem;

    @BeforeEach
    void setUp() {
        sampleItem = new Inventory();
        sampleItem.setId(1L);
        sampleItem.setName("Glow Serum");
        sampleItem.setPrice(new BigDecimal("25.00"));
        sampleItem.setBrand("Seoul Skin");
        sampleItem.setCategory("Skincare");
    }

    @Test
    public void searchInventory_ShouldReturnMappedDTOs_WhenMatchesExist() {
        // 1. ARRANGE: Tell the Mock Repository what to return
        // We use any(Specification.class) because we don't need to test the Spec itself here
        when(inventoryRepository.findAll(any(Specification.class)))
                .thenReturn(List.of(sampleItem));

        // 2. ACT: Call the service method
        List<InventoryResponseDTO> results = inventoryService.searchInventory("Skincare", "Seoul Skin", new BigDecimal("30.00"));

        // 3. ASSERT: Verify the outcome
        assertEquals(1, results.size(), "Should return exactly 1 item");
        assertEquals("Glow Serum", results.get(0).name());

        // Verify the repository was actually called
        verify(inventoryRepository, times(1)).findAll(any(Specification.class));
    }
}