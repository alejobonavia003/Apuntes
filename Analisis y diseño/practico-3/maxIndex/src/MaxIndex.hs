module MaxIndex where

-- maxindex retorna la posicion del maximo elemento de la lista
-- -- Solucion fuerza bruta 
maxindexOnlyFB :: [Int] -> Int -> (Int,Int)
maxindexOnlyFB [] _ = error " lista vacia"
maxindexOnlyFB (x:xs) y   
    | maxi x xs = (x, y)
    | otherwise = maxindexOnlyFB xs (y+1)
-- TODO: Resolver

-- Solucion FBrece 
maxindexOnlyDEC :: [Int] -> (Int, Int)
maxindexOnlyDEC [x] = (x, 0)
maxindexOnlyDEC (x:xs)   
    | x > first = (x, 0)
    | otherwise = (first, second+1)
        where (first, second) = maxindexOnlyDEC xs


maxi :: Int -> [Int] -> Bool
maxi _ [] = True 
maxi y (x:xs) 
    | y >= x = maxi y xs 
    | otherwise = False 


-- Devuelve sólo el índice
maxIndexFB :: [Int] -> Int
maxIndexFB xs = snd (maxindexOnlyFB xs 0)

maxIndexDEC :: [Int] -> Int
maxIndexDEC xs = snd (maxindexOnlyDEC xs)
