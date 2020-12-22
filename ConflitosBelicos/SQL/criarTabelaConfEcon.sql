CREATE TABLE IF NOT EXISTS confEcon(
    codConflito INT UNSIGNED NOT NULL,
    matPrima VARCHAR(30) NOT NULL,
    PRIMARY KEY(codConflito, matPrima),
    FOREIGN KEY (codConflito) REFERENCES conflito(codConflito)
)



