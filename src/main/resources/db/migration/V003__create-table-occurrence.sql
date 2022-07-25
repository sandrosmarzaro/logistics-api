CREATE TABLE
    occurrence (
        id BIGINT NOT NULL AUTO_INCREMENT,
        delivery_id BIGINT NOT NULL,
        description VARCHAR(60) NOT NULL,
        registrationDate DATETIME NOT NULL,
        CONSTRAINT pk_occurence PRIMARY KEY (id),
        CONSTRAINT fk_occurence FOREIGN KEY (delivery_id) REFERENCES delivery(id)
);