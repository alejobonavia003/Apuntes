data Tree a = Empty | Node (Tree a) a (Tree a)
    deriving (Show, Eq)

alt :: Tree a -> Int 
alt Empty = 0
alt (Node hi a hd) = 1 + max (alt hi) (alt hd)

size :: Tree a -> Int 
size Empty = 0
size (Node hi a hd) = 1 + size hi + size hd 

espejo :: Tree a ->  Tree a 
espejo Empty = Empty
espejo (Node hi r hd) = Node (espejo hd) r (espejo hi)

mapTree :: (a -> b) -> Tree a -> Tree a 
mapTree _ Empty = Empty
mapTree f (Node hi r hd) = Node (mapTree f hi) (f x) (mapTree f hd)

full :: Tree a -> Bool 
full Empty = true
full (Node hi r hd) = full hi && full hd && alt hi == alt hd 


