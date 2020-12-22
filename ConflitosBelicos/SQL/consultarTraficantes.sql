
SELECT 
    nomeTraf as Traficante,
    nomeArma as Fornece,
    nomeGrupo as Grupo_Armado
FROM fornece f INNER JOIN grupo_armado ga 
ON f.codigoG = ga.codigoG AND (f.nomeArma = 'M200 Intervention' OR f.nomeArma = 'Barret M82')

