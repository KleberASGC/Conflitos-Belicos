
SELECT pais,
     COUNT(pais) as Numero_Conflitos  
FROM conflitoPais cp INNER JOIN confRelig cr
WHERE cp.codConflito = cr.codConflito
GROUP BY pais
ORDER BY COUNT(pais) DESC

