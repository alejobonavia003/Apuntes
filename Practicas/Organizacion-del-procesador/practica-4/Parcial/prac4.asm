%include "./asm_io.inc"

segment .data 
    lista1 dd 10,2,300,4,5,6,7,8,95,0
    tam dd 9,0
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
    mov eax, [lista1]

for1: 
xor ebx, ebx
mov ebx, [lista1 + edx*4]

    push eax 
    push ebx

    call gap

    pop eax 
    pop ebx
inc edx
loop for1

  call print_int


    popa
    leave
    ret

    global gap

    gap: 
    enter 0,0 

    mov eax, [ebp + 8]
    mov ebx, [ebp + 12]


    cmp bx, ax 
    jg mayor 
     mov ax, [ebp+8]
    jmp fin
   
    mayor: 
        mov bx, [ebp+8]

    fin: 

    leave
    ret 


