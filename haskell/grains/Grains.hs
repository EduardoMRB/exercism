module Grains where

import Data.List(foldl')

square :: Integer -> Integer
square n = 2 ^ (n - 1)

total :: Integer
total = foldl' (+) 0 $ take 64 $ iterate (* 2) 1
