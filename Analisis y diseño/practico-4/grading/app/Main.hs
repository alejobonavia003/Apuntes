module Main where

import Data.List

import Grade

main :: IO ()
main = do
    
    let x =  [2, 3, 42, 12, 7]
    let y = Data.List.sort x

    let z = gradeDC x  y
    let w = length z
    

    putStrLn("The list solution between student result xs: " ++ (show x) )
    putStrLn ("and teacher result ys: " ++ (show y))
    putStrLn (" made by divide & conquer function is: " ++ (show z) )
    putStrLn ("and the grade result is: " ++ (show w))


   