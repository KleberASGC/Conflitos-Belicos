
SELECT 
    codigoOrg as Codigo_Organização,
    COUNT(codigoOrg) as Quantidade_Mediacoes
FROM entradMed 
WHERE codConflito NOT IN (SELECT codConflito FROM saidaMed)
GROUP BY codigoOrg 
ORDER BY COUNT(codigoOrg) DESC
LIMIT 5

DELETE FROM saidaMed WHERE codigoOrg = 2


