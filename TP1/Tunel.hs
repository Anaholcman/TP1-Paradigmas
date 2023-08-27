module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where
   
import Point (Point, newP, difP)
import Quality (Quality, newQ, capacityQ, delayQ )
import City ( City, newC, nameC, distanceC )
import Link ( Link, newL, linksL, connectsL, capacityL, delayL )

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT = Tun

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT city1 city2 (Tun tunnel) = (esExtremo city1 tunnel) && (esExtremo city2 tunnel)

esExtremo :: City -> [ Link ] -> Bool
esExtremo city = foldr (\link fold -> (connectsL city link && not fold)|| (not (connectsL city link) && fold)) False

usesT :: Link -> Tunel -> Bool -- indica si este tunel atraviesa ese link
usesT link (Tun linksTun)= foldr ((||).(==link)) False linksTun

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun linksTun) = foldr ( (+).delayL ) 0.0 linksTun
