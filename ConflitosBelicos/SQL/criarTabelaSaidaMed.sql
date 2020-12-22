CREATE TABLE IF NOT EXISTS saidaMed(
    codigoOrg INT UNSIGNED NOT NULL,
    codConflito INT UNSIGNED NOT NULL,
    dsMedia DATE NOT NULL,

    PRIMARY KEY (codigoOrg, codConflito, dsMedia),
    FOREIGN KEY (codigoOrg) REFERENCES organizacaoM (codigoOrg),
    FOREIGN KEY (codConflito) REFERENCES conflito (codConflito)
)


INSERT INTO saidaMed
        (codigoOrg,codConflito,dsMedia)
VALUES
        (1,1,'2015-06-06'),
        (2,2,'1990-07-07')


