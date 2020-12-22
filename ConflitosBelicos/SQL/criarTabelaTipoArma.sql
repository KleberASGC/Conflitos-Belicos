CREATE TABLE IF NOT EXISTS tipoArma (
    nomeArma VARCHAR(30) NOT NULL,
    indicador VARCHAR(30) NOT NULL,
    PRIMARY KEY(nomeArma)
)

INSERT INTO tipoArma (nomeArma,indicador)
VALUES ('M4A1', 400),
        ('M416', 360),
        ('AX-50', 1200),
        ('Origin 12', 500),
        ('UZI', 250)