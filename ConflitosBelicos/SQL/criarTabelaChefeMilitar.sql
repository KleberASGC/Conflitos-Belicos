CREATE TABLE IF NOT EXISTS chefe_militar(
    codigo_Chefe INT UNSIGNED NOT NULL AUTO_INCREMENT,
    faixa VARCHAR(30),
    nroDivisao INT UNSIGNED,
    codigoG INT UNSIGNED,
    nomeL VARCHAR(30) NOT NULL,

    PRIMARY KEY(codigo_chefe),
    FOREIGN KEY (nroDivisao) REFERENCES divisao (nroDivisao),
    FOREIGN KEY (nomeL) REFERENCES lider_politico (nomeL)
)

