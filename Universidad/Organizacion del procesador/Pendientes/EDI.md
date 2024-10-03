# (Extended Destination Index)
se usa como indice de una operacion destino. 
``` uso
mov edi, buffer_destino ; Cargar dirección de destino 
mov esi, buffer_origen ; Cargar dirección de origen 
rep movsb ; Copiar bytes de origen a destino
```

