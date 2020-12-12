CREATE TABLE IF NOT EXISTS entradMed(
    codigoOrg INT UNSIGNED NOT NULL,
    codConflito INT UNSIGNED NOT NULL,
    deMedia VARCHAR(30) NOT NULL,

    PRIMARY KEY (codigoOrg, codConflito, deMedia),
    FOREIGN KEY (codigoOrg) REFERENCES organizacaoM (codigoOrg),
    FOREIGN KEY (codConflito) REFERENCES conflito (codConflito)
)