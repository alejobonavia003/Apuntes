--Archivo stackList
module StackList where 
import StackADT

data Milista a = Vacia | Elemento a (Milista a) 
    deriving Show

instance Stack Milista where 
    isEmpty :: Milista a -> Bool
    isEmpty Vacia = True
    isEmpty _ = False

    top :: Milista a -> a 
    top Vacia = error "la lista esta vacia"
    top (Elemento x _) = x

    pop :: Milista a -> Milista a 
    pop Vacia = error "la lista esta vacia"
    pop (Elemento x xs) = xs

    push :: a -> Milista a -> Milista a
    push y xs = (Elemento y xs) 
