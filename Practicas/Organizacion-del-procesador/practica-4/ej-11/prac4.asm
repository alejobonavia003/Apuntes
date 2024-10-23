%include "./asm_io.inc"

segment .data 
    lista1 dd 10,2,3,4,5,6,7,8,9,0

section .text
    global CMAIN

CMAIN:
    enter   0,0
    pusha

    xor edx, edx; vaccio los registros para laburar mas comodo 
    xor ecx, ecx; vacio los registros para laburar mas comodo 
    xor ebx, ebx; vacio los registros para laburar mas comodo 
    xor eax, eax; vacio los registros para laburar mas comodo 

    check_palindrome:
    mov ecx, 32         ; Inicializar contador de bits (32 bits en eax)
    mov ebx, eax        ; Copia del número original en ebx
    xor edx, edx        ; Limpiar edx para usarlo como máscara temporal

palindrome_loop:
    ; Comparar bit más bajo (LSB) con el bit más alto (MSB)
    
    ; Extraer LSB (bit menos significativo)
    mov edx, ebx        ; Copiar el número en edx
    and edx, 1          ; Aislar el bit menos significativo (LSB)
    
    ; Extraer MSB (bit más significativo)
    mov eax, ebx        ; Copiar el número en eax
    shr eax, cl         ; Desplazar el bit más significativo hacia la derecha
    and eax, 1          ; Aislar el bit más significativo (MSB)
    
    ; Comparar LSB y MSB
    cmp eax, edx        ; Si los bits son diferentes, no es palíndromo
    jne not_palindrome  ; Saltar si los bits no coinciden
    
    ; Preparar para la siguiente comparación
    shr ebx, 1          ; Desplazar hacia la derecha para preparar el próximo LSB
    dec ecx             ; Decrementar el contador de bits
    
    ; Si ya se han comparado todos los bits
    cmp ecx, 1
    jg palindrome_loop  ; Continuar el loop si hay más bits por comparar

is_palindrome:
    ; El número es un palíndromo
    mov eax, 1          ; Establecer el valor de retorno en 1 (verdadero)
    ret

not_palindrome:
    ; El número no es un palíndromo
    mov eax, 0          ; Establecer el valor de retorno en 0 (falso)
    ret


    popa
    leave
    ret
