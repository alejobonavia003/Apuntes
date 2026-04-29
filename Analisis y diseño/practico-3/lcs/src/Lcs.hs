module Lcs where

import Data.List
import Data.Function
import qualified Data.ByteString as xs

--Get subsequences
subseq :: [a] -> [[a]]
subseq xs = sortBy (compare `on` length) $ subsequences xs

--Longest common subsequence using brute force
lcsBf :: Eq a => [a] -> [a] -> [a]
lcsBf xs ys = maximumBy (compare `on` length) (filter (\x -> elem x (subseq ys)) (subseq xs))


--TODO Longest common subsequence using divide and Conquer
lcsDc :: Eq a => [a] -> [a] -> [a]
lcsDc xs ys = []


hamming:: (Eq a) => [a] -> [a] -> int
hamming [] [] = 0
hamming xs [] = xs.length
hamming [] xs = xs.length
hamming (x:xs) (y:ys)   
    | x != y = 1 + hamming xs ys 
    | otherwise = hamming xs ys
