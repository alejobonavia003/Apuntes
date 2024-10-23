; hello.asm
%include "./asm_io.inc"

segment .data 
arreglo1 db 1,2,3,4; db son 1 bit 
arreglo3 dw 9,10,11,12; dw son 2 bits
arreglo2 dd 5,6,7,8; dd son 4 bits


text1 dw "arreglo 1  "
text2 dw "arreglo 2  "
text3 dw "arreglo 3  "


section .text
    global CMAIN

CMAIN:
    enter   0,0
    pusha

xor edx, edx ; inicializo el acumulador en 0 
mov ecx, 4; muevo al ecx el tamaño del arreglo 
lea edx, arreglo1; muevo al edx la primera pocicion del arreglo 
mov ebx, 0



; muestro el primer arreglo
    xor eax, eax
    mov eax, text1
    call print_string
    call print_nl 
for1:; toma siempre el ecx como tamaño del bucle 
    
    xor eax, eax
    mov al, [arreglo1 + ebx * 1]
    call print_int
    call print_nl 
    inc ebx
loop for1



xor edx, edx ; inicializo el acumulador en 0 
mov ecx, 4; muevo al ecx el tamaño del arreglo 
mov ebx, 0



; muestro el segundo arreglo
    xor eax, eax
    mov eax, text2
    call print_string
    call print_nl 
for2:; toma siempre el ecx como tamaño del bucle 
    
    xor eax, eax
    mov eax, [arreglo2 + ebx * 4]
    call print_int
    call print_nl 
    inc ebx
loop for2


xor edx, edx ; inicializo el acumulador en 0 
mov ecx, 4; muevo al ecx el tamaño del arreglo 
mov ebx, 0



; muestro el tercer arreglo
    xor eax, eax
    mov eax, text3
    call print_string
    call print_nl 
for3:; toma siempre el ecx como tamaño del bucle 
    
    xor eax, eax
    mov ax, [arreglo3 + ebx * 2]
    call print_int
    call print_nl 
    inc ebx
loop for3


    popa
    leave
    ret