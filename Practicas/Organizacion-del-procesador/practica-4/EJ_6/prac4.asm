; hello.asm
%include "./asm_io.inc"

segment .data 
arreglo dw 10,20,30,40,50,60,70,80,90,100; creo un arreglo con numeros pares y impares

texto db "La suma de los numeros pares es: ",0; creo un texto ubicativo 

espacio db ") : ",0; ajsdniasudiau

texto1 db "Arreglo en la pocicion (",0

segment .bss 

total resw 1; reservo 1 byte para ir guardando la suma 


section .text
    global CMAIN

CMAIN:
    enter   0,0
    pusha

    xor edx, edx; vaccio los registros para laburar mas comodo 
    xor ecx, ecx; vacio los registros para laburar mas comodo 
    xor ebx, ebx; vacio los registros para laburar mas comodo 
    mov ecx, 10; muevo al ecx el tamaño del arreglo 
    mov ebx, 0; muevo cero para usarlo de contador para saber donde voy 
    mov edx, 0; el edx lo uso para ir acumulando el valor del total de los impares 

 
    for1: ; inicia el bucle 

    xor eax, eax; vacio el eax para usarlo para mostrar cosas
    mov eax, [arreglo + ebx * 2]; guardo en el eax el valor del arreglo donde estoy parado
    mov dx, ax
    
    and eax, 1; guarda en el eax el bit menos significativo 
    jz es_par; si el bit menos significativo es 0 salra a es_par de lo contrario sigue



    jmp Continuar; luego salta a continuar 

    es_par: ; bloque del if para cuando es par
        xor eax, eax
        mov eax, texto1
        call print_string
        xor eax, eax


        mov eax, ebx
        inc eax
        call print_int
        xor eax, eax

        mov eax, espacio
        call print_string
        xor eax, eax

        add [total], dx; voy acumulando el total de los numeros pares 
        mov ax, [arreglo + ebx * 2]; guardo en el ax el numero en la pocicion ebx del arreglo
        call print_int; muesto en pantalla 
        call print_nl; salto de linea


    Continuar: ; continua el programa

    inc ebx; incremento el ebx para pasar a la proxima pocicion del arreglo
    loop for1; vuelvo a reproducir el bucle 

    mov eax, texto
    call print_string; muestro un texto por pantalla

    mov eax, [total]
    call print_int; muestro la suma de los numeros pares 
    call print_nl

    popa
    leave
    ret