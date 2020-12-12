CREATE TABLE IF NOT EXISTS conflitoPais (
    codConflito INT UNSIGNED NOT NULL,
    pais VARCHAR(30) NOT NULL,

    PRIMARY KEY (codConflito, pais),
    FOREIGN KEY (codConflito) REFERENCES conflito (codConflito)
)