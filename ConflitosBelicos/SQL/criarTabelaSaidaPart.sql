CREATE TABLE IF NOT EXISTS saidaPart(
    codigoG INT UNSIGNED NOT NULL,
    codConflito INT UNSIGNED NOT NULL,
    dsGrupo DATE NOT NULL,

    PRIMARY KEY (codigoG, codConflito, dsGrupo),
    FOREIGN KEY (codigoG) REFERENCES grupo_armado (codigoG),
    FOREIGN KEY (codConflito) REFERENCES conflito (codConflito)
)

