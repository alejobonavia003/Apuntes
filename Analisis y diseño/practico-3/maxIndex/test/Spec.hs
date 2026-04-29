import Test.Hspec
import MaxIndex

main :: IO ()
main = hspec spec

spec :: Spec
spec = do
  describe "maxIndexDEC" $ do
    it "Test maxIndexDEC with descending order" $ do
      maxIndexDEC [5,4,3,2,1] `shouldBe` 0
    it "Test maxIndexDEC ascending order" $ do
      maxIndexDEC [1,2,3,4,5] `shouldBe` 4  
    it "Test maxIndexDEC with random order" $ do
      maxIndexDEC [2,3,1,4] `shouldBe` 3

  describe "maxIndexFB" $ do
    it "Test maxIndexFB with descending order" $ do
      maxIndexFB [5,4,3,2,1] `shouldBe` 0
    it "Test maxIndexFB ascending order" $ do
      maxIndexFB [1,2,3,4,5] `shouldBe` 4  
    it "Test maxIndexFB with random order" $ do
      maxIndexFB [2,3,1,4] `shouldBe` 3

   