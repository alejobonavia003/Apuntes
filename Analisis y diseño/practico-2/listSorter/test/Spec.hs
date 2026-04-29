import Test.Hspec

import qualified Data.List

import Test.QuickCheck

import ListSorter

main :: IO ()
main = hspec spec

propCompare :: [Int] -> Bool
propCompare xs = selectionSort xs == slowSort xs

spec :: Spec
spec = do
    describe "ListSorter Specs: sort elements of a list" $ do
        it "Test selectionSort with empty list" $ do
                selectionSort [] `shouldBe` ([] :: [Int])
        it "Test selectionSort with input in ascending order" $ do
                selectionSort [1, 2, 5, 44, 333] `shouldBe` ([1,2,5,44,333] :: [Int])
        it "Test selectionSort with input in descending order" $ do
                selectionSort [435, 33, 5, 1] `shouldBe` ([1,5,33,435] :: [Int])
        it "Test selectionSort with input in random order" $ do
                selectionSort [8, 2, 45, 77, 33, 5, 10] `shouldBe` ([2,5,8,10,33,45,77] :: [Int])
        it "Test selectionSort with negative numbers input" $ do
                selectionSort [-8, -100, -45, -77, -33, -5, -10] `shouldBe` ([-100,-77,-45,-33,-10,-8,-5] :: [Int])
        it "Test slowSort with empty list" $ do
                slowSort [] `shouldBe` ([] :: [Int])
        it "Test slowSort with input in ascending order" $ do
                slowSort [1, 2, 5, 44, 333] `shouldBe` ([1,2,5,44,333] :: [Int])
        it "Test slowSort with input in descending order" $ do
                slowSort [435, 33, 5, 1] `shouldBe` ([1,5,33,435] :: [Int])
        it "Test slowSort with input in random order" $ do
                slowSort [8, 2, 45, 77, 33, 5, 10] `shouldBe` ([2,5,8,10,33,45,77] :: [Int])
        it "Test slowSort with negative numbers input" $ do
                slowSort [-8, -100, -45, -77, -33, -5, -10] `shouldBe` ([-100,-77,-45,-33,-10,-8,-5] :: [Int])
        --Uncomment next test after complete slowSort definition
        it "Test compare selectionSort and slowSort" $ do   
                quickCheckWith stdArgs {maxSize = 10} propCompare             
        