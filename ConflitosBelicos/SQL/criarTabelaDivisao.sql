CREATE TABLE IF NOT EXISTS divisao (
    nroDivisao INT UNSIGNED NOT NULL AUTO_INCREMENT,
    codigoG INT UNSIGNED,
    numBaixasD INT,
    barcos INT,
    tanques INT,
    homens INT,
    avioes INT,
    PRIMARY KEY (nroDivisao, codigoG),
    FOREIGN KEY (codigoG) REFERENCES grupo_armado (codigoG)
)

ALTER TABLE divisao MODIFY codigoG INT UNSIGNED;

INSERT INTO divisao (numBaixasD,barcos,tanques,homens,avioes)
VALUES (25,2,1,3,5)