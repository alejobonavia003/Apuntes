El [[Enter]] lo usamos para establecer un nuevo marco de pila.
Usa la siguiente sintaxis: 
``` c
enter n,m
```
- n : Tamaño de marco de pila en bytes que se reserva para las variables locales 
- m : cantidad de marcos que se deven precervar 

## Funcionamiento 
```c
enter 16, 0    // Reserva 16 bytes para variables locales
// Código de la función //
leave           // Restaura el marco de pila anterior
ret             // Retorna de la función
 
```
	siempre es mejor intental visualizar estas cosas con dibujos. 

