module Accumulate where

accumulate :: (a -> b) -> [a] -> [b]
accumulate _ [] = []
accumulate f (h:t) = f h : accumulate f t
