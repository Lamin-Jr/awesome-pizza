CREATE TABLE IF NOT EXISTS orders (
    id INT UNIQUE AUTO_INCREMENT PRIMARY KEY,
    pizza_type VARCHAR(255),
    quantity INT,
    status VARCHAR(255),
    order_time TIMESTAMP
    );