CREATE TABLE member (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255),
                        email VARCHAR(255)
);

CREATE TABLE orders (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        member_id BIGINT,
                        product_name VARCHAR(255),
                        order_date DATE,
                        amount DOUBLE,
                        purchase_date DATE,
                        FOREIGN KEY (member_id) REFERENCES member(id)
);

INSERT INTO member (id, name, email) VALUES (1, 'John Doe', 'john@example.com');
INSERT INTO member (id, name, email) VALUES (2, 'Jane Doe', 'jane@example.com');

INSERT INTO orders (id, member_id, product_name, order_date, amount, purchase_date) VALUES (1, 1, 'Product A', '2023-01-01', 100.0, '2023-01-01');
INSERT INTO orders (id, member_id, product_name, order_date, amount, purchase_date) VALUES (2, 2, 'Product B', '2023-01-02', 200.0, '2023-01-02');
