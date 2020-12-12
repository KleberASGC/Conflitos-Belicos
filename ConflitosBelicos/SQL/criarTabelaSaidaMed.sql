CREATE TABLE IF NOT EXISTS saidaMed(
    codigoOrg INT UNSIGNED NOT NULL,
    codConflito INT UNSIGNED NOT NULL,
    dsMedia VARCHAR(30) NOT NULL,

    PRIMARY KEY (codigoOrg, codConflito, dsMedia),
    FOREIGN KEY (codigoOrg) REFERENCES organizacaoM (codigoOrg),
    FOREIGN KEY (codConflito) REFERENCES conflito (codConflito)
)