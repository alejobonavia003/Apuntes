
data BinTree a = Nil | Node (BinTree a) a (BinTree a)

instance (Eq a) => Eq (BinTree a) where 
    Nil == Nil = True
    (Node hi1 r1 hd1) == (Node hi2 r2 hd2) = r1 == r2 && hi1 == hi2 && hd1 == hd2 
    _ == _ = False

instance (Show a) => Show (BinTree a) where 
    show Nil = "."
    show (Node hi r hd) = "(" ++ (show hi) ++ " " ++ (show r) ++ " " ++ (show hd) ++ ")" 

size :: (BinTree a) -> Int 
size Nil = 0 
size (Node hi r hd) = 1 + (size hi) + (size hd)

altura :: (BinTree a) -> Int 
altura Nil = 0
altura (Node hi r hd) = 1 + max (altura hi) (altura hd)

contains :: (Eq a) => (BinTree a) -> a -> Bool 
contains Nil _ = False 
contains (Node hi r hd) x = r == x || (contains hi x) || (contains hd x)

cantidad_nodos :: (BinTree a) -> Int 
cantidad_nodos nil = 0
cantidad_nodos (Node hi r hd) = 1 + (cantidad_nodos hi) + (cantidad_nodos hd)

inorder :: (BinTree a) -> [a]
inorder nil = [] 
inorder (Node hi r hd) = (inorder hi) ++ [r] ++ (inorder hd)

postorder :: (BinTree a) -> [a]
postorder nil = []
postorder (Node hi r hd) = r : (postorder hi) ++ (postorder hd)

preorder :: (BinTree a) -> [a]
preorder nil = [] 
preorder (Node hi r hd) = (preorder hi)  ++ (preorder hd) ++ [r]

minElem :: (Ord a) => (BinTree a) -> a
minElem Nil = error "arbol vacio"
minElem (Node Nil r Nil) = r 
minElem (Node hi r Nil) = min r (minElem hi)
minElem (Node Nil r hd) = min r (minElem hd)
minElem (Node hi r hd) = min (min (r) (minElem hi)) (min (r) (minElem hd))
    

