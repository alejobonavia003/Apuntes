module Ejercicios where 


    bisiesto :: Int -> Bool 
    bisiesto x = (mod x 4 == 0 && mod x 100 /= 0) || (mod x 400) == 0