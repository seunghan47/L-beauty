package com.paulim.lbeauty.inventory;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class InventoryDataInitializer implements CommandLineRunner {

    private final InventoryRepository inventoryRepository;

    @Override
    public void run(String... args) throws Exception {
        if (inventoryRepository.count() > 0) {
            log.info("Database already populated. Skipping data migration.");
            return;
        }

        log.info("Starting data migration from inventory.csv...");

        try (InputStreamReader reader = new InputStreamReader(
                new ClassPathResource("inventory.csv").getInputStream())) {

            List<InventoryCsvRecord> records = new CsvToBeanBuilder<InventoryCsvRecord>(reader)
                    .withType(InventoryCsvRecord.class)
                    .build()
                    .parse();

            List<Inventory> inventoryList = records.stream().map(record -> {
                Inventory item = new Inventory();
                item.setUpc(record.getUpc());
                item.setName(record.getName());
                item.setPrice(new BigDecimal(record.getPrice()));

                item.setBrand("L-Beauty Generic");
                item.setCategory("Uncategorized");
                item.setDeleted(false);

                return item;
            }).toList();

            inventoryRepository.saveAll(inventoryList);
            log.info("Successfully imported {} items into the database!", inventoryList.size());
        } catch (Exception e) {
            log.error("Failed to import inventory data: ", e);
        }
    }
}

