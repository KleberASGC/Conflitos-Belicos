CREATE TABLE IF NOT EXISTS podeFornecer(
    nomeArma VARCHAR(30),
    nomeTraf VARCHAR(30),
    quantidade INT, 
    FOREIGN KEY (nomeArma) REFERENCES tipoArma (nomeArma)
)

INSERT INTO 