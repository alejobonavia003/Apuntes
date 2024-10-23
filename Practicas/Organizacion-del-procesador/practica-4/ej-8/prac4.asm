; hello.asm
%include "./asm_io.inc"

segment .data 
    A dw 1,5,1,3,1,-6; a) ocupa 96 bits 
    positivos db 0,0
    negativos db 0,0
    text2 db "hay mas pocitivos que negativos.",0
    text1 db "hay mas negativos que pocitivos.",0

segment .bss 


section .text
    global CMAIN

CMAIN:
    enter   0,0
    pusha

    xor edx, edx; vaccio los registros para laburar mas comodo 
    xor ecx, ecx; vacio los registros para laburar mas comodo 
    xor ebx, ebx; vacio los registros para laburar mas comodo 
    xor eax, eax; vacio los registros para laburar mas comodo 

    mov ecx, 6; limite del arreglo  
    mov ebx, 0; indice del arreglo 

    for1: 
        xor eax, eax
        mov al, [A + ebx*2]
        cmp al, 0; compara al con 0
        jg es_pocitivo
            mov dx, 1
            add [negativos], dx 
            ; es negativo

            jmp fin

        es_pocitivo: 
            mov dx, 1
            add [positivos], dx
            ; es pocitivo 


        fin: 

    inc ebx
    loop for1
    
    xor eax, eax
    xor ebx, ebx 

    mov eax, [positivos]
    mov ebx, [negativos]

    cmp eax, ebx 
    jg mas_pocitivos

        xor eax, eax 
        mov eax, text1
        call print_string
        call print_nl


        jmp salir

        mas_pocitivos: 

        xor eax, eax
        mov eax, text2
        call print_string
        call print_nl

        salir: 





    popa
    leave
    ret