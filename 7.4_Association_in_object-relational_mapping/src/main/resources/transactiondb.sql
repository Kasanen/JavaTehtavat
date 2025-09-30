USE currenciesV2;

CREATE TABLE Transaction (
    id INT NOT NULL AUTO_INCREMENT,
    amount DECIMAL(12, 6) NOT NULL,
    PRIMARY KEY (id)
);

GRANT SELECT,INSERT,UPDATE,DELETE ON currenciesV2.* TO 'appuser'@'localhost';
GRANT CREATE, DROP ON currenciesV2.* TO 'appuser'@'localhost';
FLUSH PRIVILEGES;