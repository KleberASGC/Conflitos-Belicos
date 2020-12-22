CREATE TABLE IF NOT EXISTS lider_politico(
    nomeL VARCHAR(30) NOT NULL,
    codigoG INT UNSIGNED NOT NULL,
    apoios VARCHAR(30),
    PRIMARY KEY(nomeL,codigoG),
    FOREIGN KEY(codigoG) REFERENCES grupo_armado(codigoG)
)
