


hamming :: (Eq a) => [a] -> [a] -> Int
hamming [] [] = 0
hamming xs [] = length xs
hamming [] xs = length xs
hamming (x:xs) (y:ys)
    | x /= y = 1 + hamming xs ys
    | otherwise = hamming xs ys


subSeq :: (Eq a) => [a] -> [a] -> Bool
subSeq [] [] = True
subSeq [] _  = True
subSeq _ [] = False
subSeq (x:xs) (y:ys)
    | x == y = subSeq xs ys
    | otherwise = subSeq (x:xs) ys


mayorYmenor :: [Int] -> (Int,Int)
mayorYmenor [] = error "no me pases algo vacio pa"
mayorYmenor [x] =(x,x)
mayorYmenor (x:xs) = (max x (fst (mayorYmenor xs)), min x (snd (mayorYmenor xs)))



tromino :: Int -> (Int, Int) -> [(Int, Int)]
tromino 1 filled@(x,y) = [(i,j) | i <- [0..1], j <- [0..1], (i,j) /= filled]
tromino n (x,y)
    | x >= half && y <  half = [(half-1,half-1),(half-1,half),(half,half)] ++ tromino (n-1) (x-half,y)        -- cuadrante abajo-izq
    | x >= half && y >= half = [(half-1,half-1),(half-1,half),(half,half-1)] ++ tromino (n-1) (x-half,y-half) -- cuadrante abajo-der
    | x <  half && y >= half = [(half-1,half-1),(half,half-1),(half,half)] ++ tromino (n-1) (x,y-half)        -- cuadrante arriba-der
    | x <  half && y <  half = [(half-1,half),(half,half-1),(half,half)] ++ tromino (n-1) (x,y)               -- cuadrante arriba-izq
  where
    half = 2 ^ n `div` 2

