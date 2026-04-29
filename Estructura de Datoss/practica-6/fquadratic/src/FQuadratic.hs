
-- la palabra reservada data solo define tipos
data FQuadratic = Fq Float Float Float 
-- Los tipos de datos FQuadratic son de tipo tres flotantes juntos con el constructor Fq

eval1 :: FQuadratic -> Float -> Float 
eval1 (Fq a b c) x = (a * (x * x)) + (b * x) + (c)


root1 :: FQuadratic -> (Float, Float)
root1 (Fq a b c)
  | discriminante < 0 = error "no hay raices reales..."
  | otherwise = (((-b + sqrt discriminante) / (2*a)), ((-b - sqrt discriminante) / (2*a)))
  where discriminante = b*b - 4*a*c

  
