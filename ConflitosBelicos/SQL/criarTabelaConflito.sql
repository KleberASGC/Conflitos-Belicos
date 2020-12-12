CREATE TABLE IF NOT EXISTS conflito(
    codConflito INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL,
    tipoConf VARCHAR(30) NOT NULL,
    numFeridos INT UNSIGNED,
    numMortos INT UNSIGNED,
    PRIMARY KEY(codConflito)
)