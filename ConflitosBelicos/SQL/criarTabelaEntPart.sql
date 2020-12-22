CREATE TABLE IF NOT EXISTS entPart(
    codigoG INT UNSIGNED NOT NULL,
    codConflito INT UNSIGNED NOT NULL,
    deGrupo DATE NOT NULL,

    PRIMARY KEY (codigoG, codConflito, deGrupo),
    FOREIGN KEY (codigoG) REFERENCES grupo_armado (codigoG),
    FOREIGN KEY (codConflito) REFERENCES conflito (codConflito)
)

