%include "./asm_io.inc"

segment .data 
    n dd 0
    text1 dd "sumar enteros hasta: ",0
    text2 dd "sum es: ",0

segment .bss 
    input1 resd 1 ;reservo un byte para la entrada
    input2 resd 1 ;reservo un byte para otra entrada 

section .text
    global CMAIN

CMAIN:
    enter   0,0
    pusha

    xor edx, edx; vaccio los registros para laburar mas comodo 
    xor ecx, ecx; vacio los registros para laburar mas comodo 
    xor ebx, ebx; vacio los registros para laburar mas comodo 
    xor eax, eax; vacio los registros para laburar mas comodo 

    mov eax, text1
    call print_string ; muestro el primer texto por pantalla 

    call read_int
    mov [input1], eax; guardamos la entrada en eax

    push eax; guardamos en la pila eax como parametro
    call calcSum ;esta rutina devera cargar un entero en algun registro 
    pop ebx; guardamos lo que retorna la funcion en ebx

    mov eax, text2
    call print_string; mostro un par de testo

    mov eax, ebx
    call print_int; mostro el resultado 
    call print_nl


    popa
    leave
    ret




global max

calcSum: 
    enter 8,0

    xor ecx, ecx
    mov ecx, [ebp+8]; guardo el parametro en el contador del loop

    xor ebx, ebx; limpio ebx para usarlo de acumulador 
    for1:
        xor edx, edx; limpio edx para usarlo de acumulador 
        push ecx ; mando el indice como parametro
        call elevarCubo; mando a elevar al cubo al indice
        pop edx; recibo el cubo del indice
        add ebx, edx; sumo el resultado al ebx para conservarlo
    loop for1

    mov [ebp+8], ebx; muevo el resultado donde se encontraba el parametro para retornarlo

    leave
ret

elevarCubo: 
    enter 0,0
    xor eax, eax 
    mov eax, [ebp+8]; muevo el parametro al eax


    imul eax, eax; eax * eax 
    imul eax, [ebp+8]; eax * parametro


    mov [ebp+8], eax; movemos el resultado al parametro

    leave
ret 
