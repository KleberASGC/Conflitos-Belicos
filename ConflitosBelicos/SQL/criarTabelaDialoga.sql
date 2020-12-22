CREATE TABLE IF NOT EXISTS dialoga(
    nomeL VARCHAR(30) NOT NULL,
    codigoG INT UNSIGNED NOT NULL,
    codigoOrgINT UNSIGNED NOT NULL,
    
    PRIMARY KEY (nomeL, codigoG, codigoOrg),
    FOREIGN KEY (codigoG) REFERENCES grupo_armado (codigoG),
    FOREIGN KEY (nomeL) REFERENCES lider_politico (nomeL),
    FOREIGN KEY (codigoOrg) REFERENCES organizacaoM (codigoOrg)
)

