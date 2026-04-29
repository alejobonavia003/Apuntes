import Test.Hspec


import qualified Data.List

import Grade

main :: IO ()
main = hspec spec

 
spec :: Spec
spec = do
    describe "Grading Student" $ do
        it "Test grade with one empty list" $ do
                grade []  `shouldBe` (0 :: Int)
        it "Test grade inputs with descending order " $ do
                grade [5,4,3,2,1] `shouldBe` (1 :: Int)
        it "Test grade with ascending order" $ do
                grade [1,2,3,4,5]  `shouldBe` (5 :: Int)  
        it "Test grade with random order" $ do
                grade [1,3,2,4]  `shouldBe` (3 :: Int)                