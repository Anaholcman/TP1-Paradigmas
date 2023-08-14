module Point ( Point, newP, difP)
   where

data Point = Poi Int Int deriving (Eq, Show)

newP :: Int -> Int -> Point
newP coordx coordy = Poi a b
difP :: Point -> Point -> Float  -- distancia absoluta
difP (Poi x1 y2) (Poi x1 y2) = sqrt ((x1-x2)**2 + (y1-y2)**2)