module ListSorter where

-- Test ordered list
isOrdered :: Ord a => [a] -> Bool
isOrdered [] = True
isOrdered [x] = True
isOrdered (x:(y :ys)) = if x<=y then isOrdered(y:ys)  else False

-- Remove list members that satisfy the predicate
remove :: (a -> Bool) -> [a] -> [a]
remove p [] = []
remove p (x:xs) = if p x then xs else x : remove p xs


-- Sort a list by selectionSort algorithm
selectionSort :: (Ord a) => [a] -> [a]
selectionSort [] = []
selectionSort xs = selectionSort (remove (== x) xs) ++ [x]
  where x = maximum xs


-- Sort a list by Slowsort algorithm
slowSort :: (Ord a) => [a] -> [a]
slowSort xs = head(filter (isOrdered) (permutaciones xs))




-- 1
permutaciones:: (Ord a) => [a] -> [[a]]
permutaciones [x] = [[x]]
permutaciones [] = [[]]
permutaciones xs = [ x:ys | x <- xs , ys <- permutaciones(remove (==x) xs)]
-- toma un elemento de x de la lista xs 

subconjuntos:: (Eq a) => [a] -> [[a]]
subconjuntos [] = [[]]
subconjuntos (x:xs) = subconjuntos xs ++ map (x:) (subconjuntos xs)


subsecuencia :: (Ord a, Eq a) => [a] -> [a] -> Bool
subsecuencia xs ys = elem (insertionsort ys) (map (insertionsort) (subconjuntos xs ))

   
anagrama:: (Ord a) => [a] -> [a] -> Bool
anagrama _ [] = False  
anagrama xs ys = elem xs (permutaciones ys)

 

subsumas :: (Num a, Eq a) => [a] -> a -> Bool
subsumas  ys n = elem n [sum x | x <- subconjuntos ys ]  


subcadenas:: (Eq a, Ord a) => [a] -> [a] -> Bool
subcadenas _ [] = False -- no tiene donde mas buscar la subcadena 
subcadenas [] _ = True -- ya encontro toda la subcadena denmtro de ys 
subcadenas (x:xs) (y:ys) 
  | x == y = subcadenas xs ys 
  | otherwise = subcadenas (x:xs) ys 


insertionsort:: (Ord a) => [a] -> [a]
insertionsort [] = [] 
insertionsort (x:xs) = insert x (insertionsort xs)

insert :: (Ord a) => a -> [a] -> [a]
insert x [] = [x]
insert x (y:ys)
  | x <= y    = x : y : ys
  | otherwise = y : insert x ys


hamming :: (Eq a) => [a] -> [a] -> Int
hamming [] [] = 0
hamming xs [] = xs.length
hamming [] xs = xs.length
hamming (x:xs) (y:ys)   
    | x != y = 1 + hamming xs ys 
    | otherwise = hamming xs ys

