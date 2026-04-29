module SetADT where

class Set s where
    emptySet :: s a
    insert :: Ord a => a -> s a -> s a
    contains :: Ord a => a -> s a -> Bool
    union :: Ord a => s a -> s a -> s a 
    difference :: Ord a => s a -> s a -> s a 
    intersection ::Ord a => s a -> s a -> s a 
