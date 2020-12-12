CREATE TABLE IF NOT EXISTS fornece(
    codigoG INT UNSIGNED NOT NULL,
    nomeArma VARCHAR(30) NOT NULL,
    nomeTraf VARCHAR(30) NOT NULL,
    numArmas INT UNSIGNED,

    PRIMARY KEY(codigoG,nomeArma,nomeTraf),
    FOREIGN KEY (codigoG) REFERENCES grupo_armado (codigoG),
    FOREIGN KEY (nomeArma) REFERENCES tipoArma (nomeArma)
)





--fornece f INNER JOIN grupo_armado ga on f.nomeArma = 'M200 intervention' OR f.nomeArma = 'Barret M82'