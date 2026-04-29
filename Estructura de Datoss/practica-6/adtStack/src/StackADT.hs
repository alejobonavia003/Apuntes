-- archivo stackADT
module StackADT where

class Stack s where
    isEmpty :: s a -> Bool -- toma un elemento de tipo pila con elementos a y devuele bool 
    top :: s a -> a -- toma un elemento de tipo pila de elementos a y devuelve un elemento de tipo a 
    pop :: s a -> s a --toma una pila de tipo a y devuelve una pila de tipo a
    push:: a -> s a -> s a -- toma un elemento de tipo a y una pila de elementos tipo a y devuelve una pila de tipo a
    

