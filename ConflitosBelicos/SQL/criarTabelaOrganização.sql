CREATE TABLE IF NOT EXISTS organizacaoM(
    codigoOrg INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nomeOrg VARCHAR(30) NOT NULL,
    tipoAjuda VARCHAR(30) NOT NULL,
    orgLider VARCHAR(30) NOT NULL,
    nroPessoas INT,
    tipo VARCHAR(30) NOT NULL,
    PRIMARY KEY(codigoORG)
)

