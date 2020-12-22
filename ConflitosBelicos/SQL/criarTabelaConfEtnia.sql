CREATE TABLE IF NOT EXISTS confEtnia(
    codConflito INT UNSIGNED NOT NULL,
    etnia VARCHAR(30) NOT NULL,
    PRIMARY KEY(codConflito, etnia),
    FOREIGN KEY (codConflito) REFERENCES conflito(codConflito)
)

