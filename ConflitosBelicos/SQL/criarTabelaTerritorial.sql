CREATE TABLE IF NOT EXISTS territorial(
    codConflito INT UNSIGNED NOT NULL,
    regiao VARCHAR(30) NOT NULL,

    PRIMARY KEY (codConflito, regiao),
    FOREIGN KEY (codConflito) REFERENCES conflito (codConflito)
)