import Test.Hspec
import SetADT
import SetListOrd


main :: IO ()
main = hspec spec

spec :: Spec
spec = do
    describe " Test SetListOrd" $ do
        it "Test insert with empty Set" $ do
                insert 1 []   `shouldBe` ([1] :: [Int])
        it "Test insert with not empty Set " $ do
                insert 2 ((1:[3]))  `shouldBe` ([1,2,3] :: [Int])
        it "Test contains in Set" $ do
                contains 2 []  `shouldBe` (False :: Bool)