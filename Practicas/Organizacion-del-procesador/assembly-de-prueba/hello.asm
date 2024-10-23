; hello.asm
%include "./asm_io.inc"

section .data
    B db 1,2,3,4

section .text
    global CMAIN

CMAIN:
    enter   0,0
    pusha
    dump_regs 0
    xor eax, eax ; vaciar el registro 
    mov ebx, B
    mov al, [ebx+3]
    dump_regs 1
    popa ; restaura todos los registros 
    ret