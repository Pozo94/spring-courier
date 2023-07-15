CREATE TABLE customers
(
    id         VARCHAR(50) PRIMARY KEY NOT NULL,
    first_name VARCHAR(50)             NOT NULL,
    last_name  VARCHAR(50)             NOT NULL,
    email      VARCHAR(100)            NOT NULL,
    phone      VARCHAR(20)             NOT NULL,
    address    VARCHAR(200)            NOT NULL,
    version    INT
);

CREATE TABLE orders
(
    id               VARCHAR(50) PRIMARY KEY NOT NULL,
    customer_id      VARCHAR(50)             NOT NULL,
    sender_address   VARCHAR(255)            NOT NULL,
    receiver_address VARCHAR(255)            NOT NULL,
    package_type     VARCHAR(20)             NOT NULL,
    package_size     VARCHAR(20)             NOT NULL,
    delivery_date    DATE,
    status           VARCHAR(20)             NOT NULL,
    version    INT,
    FOREIGN KEY (customer_id) REFERENCES customers (id)

);

CREATE TABLE drivers
(
    id         VARCHAR(50) PRIMARY KEY NOT NULL,
    first_name VARCHAR(50)             NOT NULL,
    last_name  VARCHAR(50)             NOT NULL,
    email      VARCHAR(100)            NOT NULL,
    phone      VARCHAR(20)             NOT NULL,
    version    INT

);

CREATE TABLE tracking
(
    id          VARCHAR(50) PRIMARY KEY NOT NULL,
    order_id    VARCHAR(50),
    location    VARCHAR(255),
    description VARCHAR(255),
    event_type  VARCHAR(50),
    event_time  DATE,
    version    INT,
    FOREIGN KEY (order_id) REFERENCES orders(id)
);
CREATE TABLE shipments
(
    id    VARCHAR(50) PRIMARY KEY NOT NULL,
    order_id       VARCHAR(50),
    driver_id      VARCHAR(50),
    pickup_time DATE,
    delivery_time   DATE,
    version    INT,
    FOREIGN KEY (order_id) REFERENCES orders (id),
    FOREIGN KEY (driver_id) REFERENCES drivers (id)
);
INSERT INTO customers (id,first_name,last_name,address,phone,email,version) VALUES ('93a35482-aa55-4b5d-b53f-68a14e1f6152','Jacek','Pozwoski','ul.Wspolna 5 Krakow','668324666','jacekp@gmail.com',0);
INSERT INTO customers (id,first_name,last_name,address,phone,email,version) VALUES ('2e2b7c51-0423-4b7a-a9b3-9f196b93c5f6','Jan','Kowalski','ul.Wspólna 5 Warszawa','668999766','jank@gmail.com',0);
INSERT INTO customers (id,first_name,last_name,address,phone,email,version) VALUES ('03f01b8a-3567-4d03-84f9-2eb3a22c5fd1','Michał','Nowak','ul.Wspólna 5 Kutno','768554333','michałn@gmail.com',0);


INSERT INTO orders (id,customer_id,sender_address,receiver_address,package_type,package_size,delivery_date,status,version) VALUES ('93a35482-aa55-4b5d-b53f-68a14e1f6152','93a35482-aa55-4b5d-b53f-68a14e1f6152','Warszawa','ul.Wspolna 5 Krakow','Box','Small','2022-08-22','Delivery',0);
INSERT INTO orders (id,customer_id,sender_address,receiver_address,package_type,package_size,delivery_date,status,version) VALUES ('2e2b7c51-0423-4b7a-a9b3-9f196b93c5f6','2e2b7c51-0423-4b7a-a9b3-9f196b93c5f6','Warszawa','ul.Wspolna 5 Warszawa','Box','Small','2023-04-23','Delivery',0);
INSERT INTO orders (id,customer_id,sender_address,receiver_address,package_type,package_size,delivery_date,status,version) VALUES ('03f01b8a-3567-4d03-84f9-2eb3a22c5fd1','03f01b8a-3567-4d03-84f9-2eb3a22c5fd1','Warszawa','ul.Wspólna 5 Kutno','Box','Small','2022-06-23','Delivery',0);
INSERT INTO orders (id,customer_id,sender_address,receiver_address,package_type,package_size,delivery_date,status,version) VALUES ('95ddc30f-9a11-4a26-a2b4-69b89fe3a347','93a35482-aa55-4b5d-b53f-68a14e1f6152','Warszawa','ul.Wspólna 5 Krakow','Box','Medium','2023-08-22','Delivery',0);
INSERT INTO orders (id,customer_id,sender_address,receiver_address,package_type,package_size,delivery_date,status,version) VALUES ('b179d913-918c-4b39-9426-d8c586dcda01','2e2b7c51-0423-4b7a-a9b3-9f196b93c5f6','Warszawa','ul.Wspolna 5 Warszawa','Box','Medium','2023-04-23','Delivery',0);
INSERT INTO orders (id,customer_id,sender_address,receiver_address,package_type,package_size,delivery_date,status,version) VALUES ('a5fb1a1c-218b-4292-8b41-2df23f4466be','03f01b8a-3567-4d03-84f9-2eb3a22c5fd1','Warszawa','ul.Wspolna 5 Kutno','Box','Medium','2022-06-23','Delivery',0);
