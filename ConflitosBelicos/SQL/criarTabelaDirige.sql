CREATE TABLE IF NOT EXISTS dirige(
    cm_codigo INT UNSIGNED NOT NULL,
    di_nrodiv INT UNSIGNED NOT NULL,
    FOREIGN KEY (cm_codigo) REFERENCES chefe_militar (codigoC),
    FOREIGN KEY (di_nrodiv) REFERENCES divisao (nroDiv)
)

DROP TABLE dirige