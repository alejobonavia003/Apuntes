# Operaciones con flotantes


## Algoritmo de Suma/Resta
1) Elegir el operando con menor exponente, alienar la mantisa hacia la derecha incrementando el exponente hasta que éste coincida con el del otro operando. **(Recordar el bit oculto)**
2) Operar con las mantisas como la suma/resta de enteros.
3) Modificar el signo si fuese necesario.
4) Normalizar si fuese necesario.


## Algoritmo de Multiplicación
1) Sumar los exponentes, restando una vez la polaridad para mantenerla. ( Ejemplo IEEE Single -127)
2) Multiplicar las mantisas
3) Modificar el signo si fuese necesario
4) Normalizar si fuese necesario


## Algoritmo de División
1) Restar los exponentes, sumando una vez la polaridad para mantenerla. (Ejemplo IEEE Single -127)
2) Multiplicar las mantisas
3) Modificar el signo si fuese necesario
4) Normalizar si fuese necesario