 # push
 agrega un elemento a la pila y ahora el [[Esp]] apunta a la nueva direccion
 *hay que saber visualizar la pila para poder entender como funciona.*
![[pila_z80.png]]
Funcionamiento: 
- El [[ESP]] esta en la direccion 4096 
- si pusheamos eax a la pila. `push eax`
- ahora se movio lo que hay en eax a la pila *osea se ocuparon 4 bytes despues de la direccion de* [[ESP]] 
- ahora interna y automaticamente se le suma 4 al [[Esp]] por esto no tenemos que preocuparnos pero hay que tenerlo en cuenta para luego poder encontrar los parametros o variables locales 
