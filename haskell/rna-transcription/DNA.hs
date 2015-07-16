module DNA where

toRNA :: String -> String
toRNA strand = map translateRNA strand
  where translateRNA :: Char -> Char
        translateRNA 'C' = 'G'
        translateRNA 'G' = 'C'
        translateRNA 'A' = 'U'
        translateRNA 'T' = 'A'
        translateRNA _   = error "Not valid"
