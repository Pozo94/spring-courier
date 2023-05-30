CREATE TABLE customers
(
    id         VARCHAR(50) PRIMARY KEY NOT NULL,
    first_name VARCHAR(50)             NOT NULL,
    last_name  VARCHAR(50)             NOT NULL,
    email      VARCHAR(100)            NOT NULL,
    phone      VARCHAR(20)             NOT NULL,
    address    VARCHAR(200)            NOT NULL
);

CREATE TABLE orders
(
    id               VARCHAR(50) PRIMARY KEY NOT NULL,
    customer_id      VARCHAR(50),
    sender_address   VARCHAR(255),
    receiver_address VARCHAR(255),
    package_type     VARCHAR(20),
    package_size     VARCHAR(20),
    delivery_date    DATE                ,
    status           VARCHAR(20)         ,
    FOREIGN KEY (customer_id) REFERENCES customers (id)

);

CREATE TABLE drivers
(
    id         VARCHAR(50) PRIMARY KEY NOT NULL,
    first_name VARCHAR(50)             NOT NULL,
    last_name  VARCHAR(50)             NOT NULL,
    email      VARCHAR(100)            NOT NULL,
    phone      VARCHAR(20)             NOT NULL

);
CREATE TABLE shipments
(
    shipment_id    VARCHAR(50) PRIMARY KEY NOT NULL,
    order_id       VARCHAR(50),
    driver_id      VARCHAR(50),
    vehicle_id     VARCHAR(50),
    departure_time DATETIME,
    arrival_time   DATETIME,
    FOREIGN KEY (order_id) REFERENCES orders (id),
    FOREIGN KEY (driver_id) REFERENCES drivers (id)
);
CREATE TABLE tracking
(
    id          VARCHAR(50) PRIMARY KEY NOT NULL,
    order_id    VARCHAR(50),
    location    VARCHAR(255),
    description VARCHAR(255),
    event_type  VARCHAR(50),
    event_time  DATETIME,
    FOREIGN KEY (order_id) REFERENCES orders(id)
);