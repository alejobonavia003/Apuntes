module Grade where

import Data.Array
import Data.List

-- grading student solutions 
grade :: [Int] -> Int
grade xs = length (gradeDC (Data.List.sort xs) xs )

gradeDC :: Eq a => [a] -> [a] -> [a]
gradeDC [] ys = []
gradeDC xs [] = []
gradeDC (x:xs) (y:ys) 
  | x == y    = x : gradeDC xs ys
  | otherwise = longest (gradeDC (x:xs) ys) (gradeDC xs (y:ys))
    where
        longest xs ys = if length xs > length ys then xs else ys

--grade Optimization
--gradeMemo :: Eq a => [a] -> [a] -> [a]
