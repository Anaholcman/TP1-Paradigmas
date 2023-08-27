module Point ( Point, newP, difP)
   where

data Point = Poi Int Int deriving (Eq, Show)

newP :: Int -> Int -> Point
newP = Poi

difP :: Point -> Point -> Float  -- distancia absoluta
difP (Poi coordx1 coordy1) (Poi coordx2 coordy2) = sqrt (fromIntegral( (coordx1 - coordx2) * (coordx1 - coordx2) + ( coordy1 - coordy2 ) * ( coordy1 - coordy2 )))