CREATE TABLE inventory (
    id BIGINT NOT NULL AUTO_INCREMENT,
    upc VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    category VARCHAR(255),
    brand VARCHAR(255),
    rating DOUBLE NOT NULL DEFAULT 0.0,
    created_at DATETIME(6),
    updated_at DATETIME(6),
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE clicked_items (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    upc VARCHAR(255),
    created_at DATETIME(6),
    date DATE,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE career (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(255),
    message VARCHAR(255),
    PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE new_item (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    company VARCHAR(255),
    date VARCHAR(255),
    email VARCHAR(255),
    PRIMARY KEY (id)
) ENGINE=InnoDB;