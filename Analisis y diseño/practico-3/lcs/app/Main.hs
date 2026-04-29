module Main where

import Lcs

main :: IO ()
main = do
    
    let x =  "thisone_subsequence"
    let y =  "other_subsequence"

     -- Call the functions lcs.
    let z = lcsBf x y 

    putStrLn("The longest common subsequence between xs: " ++ (show x) )
    putStrLn ("and ys: " ++ (show y))
    putStrLn ("lcs by brute force function : " ++ (show z))

    

