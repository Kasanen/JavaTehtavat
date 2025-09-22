DROP DATABASE IF EXISTS currencies;
CREATE DATABASE currencies;
USE currencies;

CREATE TABLE CURRENCY (
    id INT NOT NULL AUTO_INCREMENT,
    abbreviation VARCHAR(3) UNIQUE NOT NULL,
    name VARCHAR(50) NOT NULL,
    conversion_rate DECIMAL(12, 6) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO CURRENCY (abbreviation, name, conversion_rate) VALUES
('USD', 'US Dollar', 1.000000),
('EUR', 'Euro', 0.920000),
('GBP', 'British Pound', 0.790000),
('JPY', 'Japanese Yen', 147.500000),
('CAD', 'Canadian Dollar', 1.360000),
('AUD', 'Australian Dollar', 1.550000),
('CHF', 'Swiss Franc', 0.890000),
('CNY', 'Chinese Yuan', 7.300000);

DROP USER IF EXISTS 'appuser'@'localhost';
CREATE USER 'appuser'@'localhost' IDENTIFIED BY '123';
GRANT SELECT, INSERT, UPDATE, DELETE ON currencies.* TO 'appuser'@'localhost';
FLUSH PRIVILEGES;