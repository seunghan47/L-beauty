CREATE TABLE inventory (
    id BIGINT NOT NULL AUTO_INCREMENT,
    upc VARCHAR(20) NOT NULL UNIQUE, -- UPCs are usually short and must be unique
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,    -- Supports up to $99,999,999.99
    category VARCHAR(100),
    brand VARCHAR(100),
    rating DOUBLE DEFAULT 0.0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE=InnoDB;