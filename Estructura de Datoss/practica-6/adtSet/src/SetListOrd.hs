module SetListOrd where
import SetADT

instance Set [] where
    emptySet = []

    insert :: (Ord a) => a -> [a] -> [a]
    insert x [] = x : [] 
    insert y (x : xs) = y : insert x xs

    contains :: (Ord a) => a -> [a] -> Bool
    contains y [] = False 
    contains y (x:xs) | x == y = True
                      | otherwise = contains y xs 

    union :: (Ord a) => [a] -> [a] -> [a]
    union xs [] = xs
    union [] ys = ys 
    union (y:ys) (x:xs)
        | x < y = x : union xs (y:ys)
        | x > y = y : union (x:xs) ys
        | otherwise = x : union xs ys

    difference :: (Ord a) => [a] -> [a] -> [a]
    difference xs [] = xs
    difference [] ys = ys 
    difference (y:ys) (x:xs) | (contains y (x:xs)) = difference ys (x:xs)
                             | otherwise = y : difference ys (x:xs)

    intersection :: (Ord a) => [a] -> [a] -> [a]
    intersection [] _ = []
    intersection _ [] = []
    intersection (y:ys) xs | contains y xs = y : intersection ys xs
                           | otherwise = intersection ys xs


    


    --ToDo: Define tad operations. 