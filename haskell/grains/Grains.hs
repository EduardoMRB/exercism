module Grains where

square :: Int -> Int
square n = last $ take n $ iterate (* 2) 1

total :: Int
total = foldl (+) 0 $ take 64 $ iterate (* 2) 1
