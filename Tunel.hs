module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where
   
import Point (Point, newP, difP)
import Quality (Quality, newQ, capacityQ, delayQ )
import City ( City, newC, nameC, distanceC )
import Link ( Link, newL, linksL, connectsL, capacityL, delayL )
import GHC.Exts.Heap (GenClosure(link))

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT = Tun

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT city1 city2 (Tun tunnel) = (esExtremo city1 tunnel) && (esExtremo city2 tunnel)
--{ dadas dos ciudades esta función da si si las ciudades son los extremos del túnel }

esExtremo :: City -> [ Link ] -> Bool
esExtremo city = foldr (\link fold -> (connectada link && not fold)|| (not (connectada link) && fold)) False
   where connectada = connectsL city

-- usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
-- usesT link [] = False
-- usesT link (tunnel : links) 
--    | link == tunnel = True
--    | otherwise = usesT link links --no se si en este caso hay que poner = tunnel tunnels

-- no es mejor asi????
usesT :: Link -> Tunel -> Bool -- indica si este tunel atraviesa ese link
usesT link (Tun linksTun)= foldr ((||).(==link)) False linksTun


delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun linksTun) = foldr ( (+).delayL ) 0.0 linksTun
