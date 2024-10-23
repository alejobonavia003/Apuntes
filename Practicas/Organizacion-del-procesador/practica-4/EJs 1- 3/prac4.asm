; hello.asm
%include "./asm_io.inc"

segment .data 
    L1 db 0b10010 ;numero 18 en binario
    L11 db 0
    valor_hex db 0x34 ; 52 en hexadecimal de 1 byte
    L6 db 18h
    Lc dd 1Ah


section .text
    global CMAIN

CMAIN:
    enter   0,0
    pusha

;   COMO COMPILAR
;       nasm -f elf $file.asm
;       gcc -m32  -o $file driver.c asm_io.o $file.o 
; EJERCICIO 1


;   a. Incrementar el valor del registro EAX.
    xor eax, eax
    xor ebx, ebx
    xor ecx, ecx
    mov eax, 4

    dump_regs 0 

    inc eax

    dump_regs 1

;   b. Cargar el registro EBX con el decimal 18 utilizando una etiqueta label binaria.
    

    mov ebx, [L1] 

    dump_regs 2

;   c. sumar al eax 200 en decimal 

    add eax, 200


;   d. Cargar el registro AX (parte baja del registro EAX) con el contenido de la celda de memoria cuya dirección está almacenada en el registro EBX.

    ;Lo que esta almacenado en ebx lo tenia en L1 por eso la use ademas los registros no tienen direccion de memoria ya que estan en el procesador 
    lea ebx, [L1]; almaceno la direccion de memoria de l2 en ebx
    mov ax, [ebx]; guardo lo que hay dentro de cuya direccion de menoria 

    dump_regs 3 

;   e. Multiplicar el valor 52 almacenado en una etiqueta en formato hexadecimal, con el valor cuya dirección de memoria está almacenada en el registro EBX.
    mov ax, [valor_hex]; ax = 0x34 = 52 en decimal 

    imul ax, [ebx]; ax = ax * 18 = 936      

    dump_regs 4

;   f. Sumar al registro EAX el contenido de la celda de memoria cuya dirección es calculada incrementando el registro EBX en 4 unidades.
    add eax, [ebx+4]; le sumo  a eax el contenido de 4 direcciones despues de la de ebx

    dump_regs 5
;--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    xor eax, eax
    xor ebx, ebx
    xor ecx, ecx
; deverian verce todos los registros vacios 


; EJERCICIO 2. 
;   Indicar con qué valores queda representado el registro extendido EAX de la arquitectura 80386, según las operaciones aplicadas:
;   a) L11 db 0
    mov eax, L11
    ; queda guardada la direccion de memoria de L11
    xor eax, eax
;   b)     L6 db 18h
    mov eax, [L6]
    add eax, [L6]
    ;queda 30 en el eax
    xor eax, eax
;   c)      Lc dd 1Ah
    mov al, [Lc]
    ;queda 1A en los primeros 8 bits del registro 
    
;   d) 
    mov ax,5h
    shl ax, 1
    shr ax, 1
    ;queda 5h en la parte de ax por que hace un shift para la derecga y uno para la izquierda 
    xor eax, eax

;   e) 
    mov al, 0110b
    rol al, 1
    rol al, 2
    ;quda 48 por que los dos 1 del medio se shiftean 3 veces a la derecha sin rotar por que no pasa los 8 queda 00110000 = 48d = 30h
    xor eax, eax
;--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    xor eax, eax
    xor ebx, ebx
    xor ecx, ecx
; deverian verce todos los registros vacios 


; EJERCICIO 3. 
;   .data: Usado para variables inicializadas, ocupa espacio en el archivo ejecutable.
;   .bss: Usado para variables no inicializadas, no ocupa espacio en el archivo ejecutable, pero reserva espacio en la memoria durante la ejecución.

    ret