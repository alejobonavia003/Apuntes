%include "./asm_io.inc"

segment .data 

section .text
    global CMAIN

CMAIN:
    enter   0,0
    pusha

    xor edx, edx; vaccio los registros para laburar mas comodo 
    xor ecx, ecx; vacio los registros para laburar mas comodo 
    xor ebx, ebx; vacio los registros para laburar mas comodo 
    xor eax, eax; vacio los registros para laburar mas comodo 








    popa
    leave
    ret