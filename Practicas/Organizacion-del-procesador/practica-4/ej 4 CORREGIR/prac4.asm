; hello.asm
%include "./asm_io.inc"

segment .data 
num db 5
contador db 10 ; contador inicial del bucle
limite db 5; limite del bucle for 
cont db 0; contador para el bucle for 

section .text
    global CMAIN

CMAIN:
    enter   0,0
    pusha

;   COMO COMPILAR
;       nasm -f elf $file.asm
;       gcc -m32  -o $file driver.c asm_io.o $file.o 
;-----------------------------------------------------------------------------------------------------------------------------------------------------------
; EJERCICIO 4

; Ejemplo de if
;  if (num > 0) {avisa} else {sale del programa}

mov al, [num]
cmp al, 0; compara al con 0
jg es_pocitivo; salta si es mayor a cero 

    jmp fin ; si es menor que cero se va al final 

es_pocitivo :; aca ponemos lo que va a hacer si es pocitivo

;----------------------------- 
;   aca va el cuerpo del if
;-----------------------------

dump_regs 1

fin: ; si entra por aca es que es negativo que por lo que se salteo el proceso de si fuera pocitivo

; EJEMPLO DE BUCLE WHILE
;  while (contador <= 0) {alguna operacon}

bucle_while: 
cmp byte [contador], 0; comparamos el contador con cero 
jle fin_while; si el contador es menor o igual que cero sale del bucle 

;-----------------------------
; ACA ESTARIA EL CUERPO DEL BUCLE 
;-----------------------------

dec byte [contador] 
jmp bucle_while; vuelve al inicio del bucle 


fin_while: ;Aca viene cuando sale del bucle 


; EJEMPLO DE BUCLE FOR 
xor ecx, ecx 
bucle_for: 
mov ecx, [cont]
cmp ecx, [limite]; compara el contador con el limite 
jge fin_for; si el contador es mayor o igual al limite sale del bucle 

;-----------------------------
; ACA IRIA EL CUERPO DEL BUCLE 
;-----------------------------

inc byte [cont]; incrementa el contador 
jmp bucle_for; volver al inicio del bucle 

fin_for: 
;aca termina el bucle 
    ret