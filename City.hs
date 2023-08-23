module City ( City, newC, nameC, distanceC )
   where

data City = Cit String Point deriving (Eq, Show)

newC :: String -> Point -> City
newC name location = Cit name location

nameC :: City -> String
nameC Cit name location = name 

distanceC :: City -> City -> Float
distanceC (Cit name1 location1) (Cit name2 location2) = difP location1 location2