Las subrutinas son una forma de modularizar codigo, por eso estas son porciones de codigo independiente. 

![[Call]], ![[Ret]],![[Push]], ![[Pop]]

![[Esp]]


**PUSHEAR:** poner el el tope de la pila.
**POPEAR**: sacar elementos de la pila.

![[EBP]]

### Parametros 
los parametros los guardamos al final de la pila y por convencion ocupan 4 bytes 


**El codigo de nuestro programa esta en la memoria y se subdivide de esta manera**.

| Codigo programa      | codigo del programa | memoria |
| -------------------- | ------------------- | ------- |
| Datos estaticos      | datos estaticos     | memoria |
| pila sin usar        | pila                | memoria |
| variables locales    | pila                | memoria |
| ebp viejo            | pila                | memoria |
| direccion de retorno | pila                | memoria |
| parametros           | pila                | memoria |
[[Enter]], [[Leave]], [[PopA]], [[PushA]], [[Tareas a liquidar]]

