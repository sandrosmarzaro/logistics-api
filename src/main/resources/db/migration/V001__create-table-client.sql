CREATE TABLE
  client (
    id BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(60) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    CONSTRAINT pk_client PRIMARY KEY (id)
  );