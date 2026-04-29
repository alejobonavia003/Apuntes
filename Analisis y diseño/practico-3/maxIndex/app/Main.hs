module Main where

import MaxIndex

main :: IO ()
main = do
  let x = [2, 3, 42, 12, 7]

  -- Call the functions (nombres corregidos)
  let z = maxIndexDEC x
  let w = maxIndexFB x

  putStrLn ("The index of max element in: " ++ show x)
  putStrLn (" made by decrease function is : " ++ show z)
  putStrLn (" made by BF function is: " ++ show w)
