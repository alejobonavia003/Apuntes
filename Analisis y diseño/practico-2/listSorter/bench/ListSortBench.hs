import Criterion.Main
import System.Random
import Control.Monad


import qualified Data.List
import ListSorter


int :: Int -> IO Int
int n = randomRIO (0,n)

benchAtSize :: Int -> Benchmark
benchAtSize n =
    env (replicateM n (int n)) $
    \xs ->
         bgroup (show n)
           [ bench "Data.List.sorter"     $ nf Data.List.sort xs
           , bench "selectionSort"  $ nf selectionSort xs
           , bench "slowSort"  $ nf slowSort xs
           ]

main :: IO ()
main = defaultMain (map benchAtSize [3,5,10]) 
