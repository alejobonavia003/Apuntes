%include "./asm_io.inc"

segment .data 
    lista1 dd 10,2,300,4,50,6,7,80,9,0

section .text
    global CMAIN

CMAIN:
    enter   0,0
    pusha

    xor edx, edx; vaccio los registros para laburar mas comodo 
    xor ecx, ecx; vacio los registros para laburar mas comodo 
    xor ebx, ebx; vacio los registros para laburar mas comodo 
    xor eax, eax; vacio los registros para laburar mas comodo 

    mov ecx, 10 
    mov ax, [lista1]
     
    for1: 
        xor ebx, ebx 
        mov bx, [lista1 + 4*edx]

        push eax
        push ebx 

        call max 

        pop eax  
        pop ebx 

        inc edx 

    loop for1
    
    call print_int
    call print_nl 

    popa
    leave
    ret
global max; ??????
max:    ; nombre de la subrutina 
    enter 0,0 ; reservo 0 byrtes para variables locales

    mov eax, [ebp + 8]; 8 direcciones despues del ebp esta el primer parametro 
    mov ebx, [ebp + 12]; 12 direcciones despues del ebp esta el segundo parametro 
    ; ahora tenemos en eax el primer parametro y en ebx tenemos el segundo parametro 

    cmp ax, bx 
    jg mayor; salta si eax es mayor 
        mov [ebp + 8], ebx; movemos el mayor al primer parametro 

    jmp finsi  

    mayor: ;si ax es mayor a bx...
        mov [ebp + 8], eax; movemos al primer parametro el mayor 
;movemos al primer parametro para luego poder hacer un pop y retirar el mayor 
    finsi: 

    leave 
ret 