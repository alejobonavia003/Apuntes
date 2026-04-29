module Main where

import ListSorter

main :: IO ()
main = do
    putStrLn("Sort list")
    let x =  [2, 3, 42, 12, 7]
    -- Call the functions to sort a list.
    let y = selectionSort x
    putStrLn ("Input list: " ++ (show x))
    putStrLn ("Sorted list by selectionSort function : " ++ (show y))

