CREATE TABLE IF NOT EXISTS fornece(
    codigoG INT UNSIGNED NOT NULL,
    nomeArma VARCHAR(30) NOT NULL,
    nomeTraf VARCHAR(30) NOT NULL,
    numArmas INT UNSIGNED,

    PRIMARY KEY(codigoG,nomeArma,nomeTraf),
    FOREIGN KEY (codigoG) REFERENCES grupo_armado (codigoG),
    FOREIGN KEY (nomeArma) REFERENCES tipoArma (nomeArma)
)





