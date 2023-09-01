CREATE TABLE IF NOT EXISTS client
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    name            VARCHAR(255) NOT NULL
);

-- Создаем таблицу contacts, если она не существует
CREATE TABLE IF NOT EXISTS contacts
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    email           VARCHAR(255),
    phone_number    VARCHAR(255),
    client_id       BIGINT,
    FOREIGN KEY     (client_id) REFERENCES client (id)
);