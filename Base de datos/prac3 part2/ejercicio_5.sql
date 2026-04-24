set search_path = part2;

SELECT v.nombre , COUNT(vac.dni) AS cantidad_aplicada
FROM vacunas v
LEFT JOIN vacunados vac
    ON v.cod_vacuna = vac.cod_vacuna
GROUP BY v.nombre
ORDER BY cantidad_aplicada DESC;




-- b) 

WITH conteo AS (
    SELECT dni, COUNT(cod_vacuna) AS cantidad_vacunas
    FROM vacunados
    GROUP BY dni
)
SELECT p.dni, p.nombre, p.municipio, c.cantidad_vacunas
FROM conteo c
JOIN personas p ON c.dni = p.dni
WHERE c.cantidad_vacunas = (SELECT MAX(cantidad_vacunas) FROM conteo);

--c)


select per.nombre, count(vac.cod_vacuna) as vac_aplicadas
from personas per
left join vacunados vac
	on per.dni = vac.dni
group by per.nombre
order by vac_aplicadas 

	

