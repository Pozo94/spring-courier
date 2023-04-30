CREATE TABLE customers (
                           customer_id INT PRIMARY KEY AUTO_INCREMENT,
                           first_name VARCHAR(50) NOT NULL,
                           last_name VARCHAR(50) NOT NULL,
                           email VARCHAR(100) NOT NULL,
                           phone VARCHAR(20) NOT NULL,
                           address VARCHAR(200) NOT NULL
);
CREATE TABLE addresses (
                           address_id INT PRIMARY KEY AUTO_INCREMENT,
                           street VARCHAR(100) NOT NULL,
                           city VARCHAR(50) NOT NULL,
                           postal_code VARCHAR(20) NOT NULL,
                           country VARCHAR(50) NOT NULL
);CREATE TABLE orders (
                          order_id INT PRIMARY KEY AUTO_INCREMENT,
                          customer_id INT NOT NULL,
                          sender_address_id INT NOT NULL,
                          receiver_address_id INT NOT NULL,
                          package_type VARCHAR(20) NOT NULL,
                          package_size VARCHAR(20) NOT NULL,
                          delivery_date DATE NOT NULL,
                          status VARCHAR(20) NOT NULL,
                          FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
                          FOREIGN KEY (sender_address_id) REFERENCES addresses(address_id),
                          FOREIGN KEY (receiver_address_id) REFERENCES addresses(address_id)
  );CREATE TABLE shipments (
                               shipment_id INT PRIMARY KEY AUTO_INCREMENT,
                               order_id INT NOT NULL,
                               driver_id INT NOT NULL,
                               vehicle_id INT NOT NULL,
                               departure_time TIMESTAMP NOT NULL,
                               arrival_time TIMESTAMP NOT NULL,
                               FOREIGN KEY (order_id) REFERENCES orders(order_id),
                               FOREIGN KEY (driver_id) REFERENCES drivers(driver_id),
                               FOREIGN KEY (vehicle_id) REFERENCES vehicles(vehicle_id)
    );CREATE TABLE drivers (
                               driver_id INT PRIMARY KEY AUTO_INCREMENT,
                               first_name VARCHAR(50) NOT NULL,
                               last_name VARCHAR(50) NOT NULL,
                               email VARCHAR(100) NOT NULL,
                               phone VARCHAR(20) NOT NULL,
                               address_id INT NOT NULL,
                               FOREIGN KEY (address_id) REFERENCES addresses(address_id)
      );CREATE TABLE vehicles (
                                  vehicle_id INT PRIMARY KEY AUTO_INCREMENT,
                                  make VARCHAR(50) NOT NULL,
                                  model VARCHAR(50) NOT NULL,
                                  year INT NOT NULL,
                                  registration_number VARCHAR(20) NOT NULL
        )

