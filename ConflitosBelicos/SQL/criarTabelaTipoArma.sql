CREATE TABLE IF NOT EXISTS tipoArma (
    nomeArma VARCHAR(30) NOT NULL,
    indicador VARCHAR(30) NOT NULL,
    PRIMARY KEY(nomeArma)
)

INSERT INTO tipoArma (nomeArma,indicador)
VALUES ('Barret M82', '82'),
        ('M200 Intervention','200')