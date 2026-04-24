--a) 
set search_path = part2;


    CREATE OR REPLACE FUNCTION descripcion_mayuscula()
RETURNS TRIGGER AS $$
BEGIN
    NEW.descripcion := UPPER(NEW.descripcion);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_descripcion_mayuscula
BEFORE INSERT ON articulos
FOR EACH ROW
EXECUTE FUNCTION descripcion_mayuscula();


PEDIR UNA FAKING CONSULTA POR QUE NO ENTIENDO 

de su defecto aprenderlo antes de redir con videos de youtube 

en 30 lo tenes adentro :: https://www.youtube.com/watch?v=rzML_5HqnhI
