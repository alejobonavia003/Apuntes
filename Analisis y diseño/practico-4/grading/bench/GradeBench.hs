import Criterion.Main
import Control.Monad
import Test.QuickCheck

import qualified Data.List
import Grade


setupEnv = do
  let xs = [1..50] :: [Int] 
  let ys = Data.List.sort xs
  return (xs,ys)
    
main :: IO ()
main = defaultMain [
        env setupEnv  $ \ ~(xs,ys) -> bgroup "main" [
          bgroup "grade" [
            bench "gradeDC" $ nf (gradeDC xs)  ys
            -- add bench "gradeMemo" 
          ]
        ]
      ] 

