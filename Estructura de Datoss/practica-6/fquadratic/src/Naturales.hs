
data Nat = Zero | Succ Nat 
    deriving Show

suma :: Nat -> Nat -> Nat 
suma Zero n = n
suma (Succ n) m = Succ (suma n m)  

natToInt :: Nat -> Int 
natToInt Zero = 0
natToInt (Succ n) = 1 + (natToInt n)

producto :: Nat -> Nat -> Nat 
producto Zero _ = Zero
producto _ Zero = Zero
producto (Succ n) m = suma m (producto n m)

