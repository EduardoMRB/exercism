module Grains where

square :: Integer -> Integer
square n = 2 ^ (n - 1)

total :: Integer
total = foldl (+) 0 $ take 64 $ iterate (* 2) 1
