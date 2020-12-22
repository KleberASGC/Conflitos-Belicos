CREATE TABLE IF NOT EXISTS divisao (
    nroDivisao INT UNSIGNED NOT NULL AUTO_INCREMENT,
    codigoG INT UNSIGNED,
    numBaixasD INT,
    barcos INT,
    tanques INT,
    homens INT,
    avioes INT,
    codigo_Chefe INT UNSIGNED NOT NULL
    PRIMARY KEY (nroDivisao, codigoG),
    FOREIGN KEY (codigoG) REFERENCES grupo_armado (codigoG)
)

DELIMITER $$
 CREATE TRIGGER checa_chefe AFTER INSERT 
        ON divisao
    FOR EACH ROW
    BEGIN
    IF ((SELECT COUNT(codigo_Chefe) FROM divisao WHERE codigo_Chefe = NEW.codigo_Chefe) > 3) 
    THEN DELETE FROM divisao WHERE nroDivisao = NEW.nroDivisao;
    END IF;
    END;$$

DELIMITER $$
 CREATE TRIGGER soma_baixas AFTER INSERT 
        ON divisao
    FOR EACH ROW
    BEGIN
    IF (NEW.numBaixasD > 0)  
    THEN UPDATE grupo_armado SET grupo_armado.numBaixasG = (grupo_armado.numBaixasG + NEW.numBaixasD) 
    WHERE NEW.codigoG = grupo_armado.codigoG;
    END IF;
    END;$$    


DELIMITER $$
 CREATE TRIGGER gera_nroDiv BEFORE INSERT 
        ON divisao
    FOR EACH ROW
    BEGIN
    IF (NEW.nroDivisao < (SELECT MAX(nroDivisao) FROM divisao WHERE codigoG = NEW.codigoG) 
        OR NEW.nroDivisao > (SELECT MAX(nroDivisao) FROM divisao WHERE codigoG = NEW.codigoG) + 1 )  
    THEN SET NEW.nroDivisao = ((SELECT MAX(nroDivisao) FROM divisao WHERE codigoG = NEW.codigoG) + 1)
    END IF;
    END;$$    

