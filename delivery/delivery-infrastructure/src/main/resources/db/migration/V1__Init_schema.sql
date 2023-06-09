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