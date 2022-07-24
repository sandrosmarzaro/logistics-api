CREATE TABLE
    delivery (
         id BIGINT NOT NULL AUTO_INCREMENT,
         client_id BIGINT NOT NULL,
         rate DECIMAL(10, 2) NOT NULL,
         status VARCHAR(10) NOT NULL,
         requestedAt DATETIME NOT NULL,
         finishedAt DATETIME,
         recipient_name VARCHAR(60) NOT NULL,
         recipient_address VARCHAR(255) NOT NULL,
         recipient_number VARCHAR(30) NOT NULL,
         recipient_complement VARCHAR(60) NOT NULL,
         recipient_neighborhood VARCHAR(30) NOT NULL,
         CONSTRAINT pk_delivery PRIMARY KEY (id),
         CONSTRAINT fk_client_delivery FOREIGN KEY(client_id) REFERENCES client(id)
);
