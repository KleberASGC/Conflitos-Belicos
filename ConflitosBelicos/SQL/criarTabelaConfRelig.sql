CREATE TABLE IF NOT EXISTS confRelig(
    codConflito INT UNSIGNED NOT NULL,
    religiao VARCHAR(30) ,
    PRIMARY KEY(codConflito, religiao),
    FOREIGN KEY (codConflito) REFERENCES conflito(codConflito)
)



