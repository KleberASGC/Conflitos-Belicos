CREATE TABLE IF NOT EXISTS conflito(
    codConflito INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL,
    tipoConf VARCHAR(30) NOT NULL,
    numFeridos INT UNSIGNED,
    numMortos INT UNSIGNED,
    paisAfetado VARCHAR(30) NOT NULL,
    PRIMARY KEY(codConflito)
)


DELIMITER $$
 CREATE TRIGGER checa_conflito AFTER INSERT 
        ON conflito
    FOR EACH ROW
    BEGIN
    IF (NEW.tipoConf = 'Econômico') 
    THEN INSERT INTO confEcon (codConflito,matPrima) VALUES (NEW.codConflito,'');
    END IF;
	IF (NEW.tipoConf = 'Religioso')
    THEN INSERT INTO confRelig (codConflito,religiao) VALUES (NEW.codConflito,'');
    END IF;
	IF (NEW.tipoConf = 'Territorial')
    THEN INSERT INTO territorial (codConflito,regiao) VALUES (NEW.codConflito,'');
    END IF;
    IF (NEW.tipoConf = 'Racial')
    THEN INSERT INTO confEtnia (codConflito,etnia) VALUES (NEW.codConflito,'');
    END IF;
    END;$$
            
DELIMITER $$
 CREATE TRIGGER checa_pais AFTER INSERT 
        ON conflito
    FOR EACH ROW
    BEGIN
    INSERT INTO conflitopais (codConflito,pais) VALUES (NEW.codConflito,NEW.paisAfetado);
    END;$$


            


