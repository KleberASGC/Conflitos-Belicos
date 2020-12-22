SELECT 
    codigoG as Codigo_Grupo,
    SUM(numArmas) as Armas 
FROM fornece
GROUP BY codigoG 
ORDER BY SUM(numArmas) DESC
LIMIT 5




