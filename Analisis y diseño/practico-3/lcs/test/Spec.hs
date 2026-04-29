import Test.Hspec

import Test.QuickCheck

import qualified Data.List

import Lcs

propLcs :: String -> String -> Bool
propLcs xs ys = length (lcsBf xs ys) == length (lcsDC xs ys) 


main :: IO ()
main = hspec spec

 
spec :: Spec
spec = do
    describe "Longest Common Subsequence" $ do
        it "Test lcsBf with one empty list" $ do
                lcsBf [] "ACDBAC" `shouldBe` ([] :: String)
        it "Test lcsBf inputs with no element in common " $ do
                lcsBf "BCDAACD" "FGHHFG" `shouldBe` ([] :: String)
        it "Test lcsBf with equal list" $ do
                lcsBf "BCDAACD" "BCDAACD" `shouldBe` ("BCDAACD" :: String)        
        --Uncomment next test after complete lcsDC definition                
        --it "Test to compare lcsBf and lcsDC results" $ do    
                --quickCheckWith stdArgs { maxSize = 15}  propLcs 
                --use verboseCheckWith to see the actual values generated
          