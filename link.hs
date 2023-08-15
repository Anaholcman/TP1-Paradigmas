module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
   where

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL city1 city2 calidad = Lin city1 city2 calidad
connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL iscity (Lin city1 city2 calidad) = iscity == city1 || iscity == city2
linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
linksL iscity1 iscity2 (Lin city1 city2 calidad) = (iscity1 == city1 && iscity2 == city2) || (iscity1 == city2 && iscity2 == city1)
capacityL :: Link -> Int
capacityL (Lin city1 city2 calidad) = capacityQ calidad
delayL :: Link -> Float     -- la demora que sufre una conexion en este canal
delayL (Lin city1 city2 calidad) = delayQ calidad

connectsT city1 city2 conections = foldr (\conection conections -> (||) linksL city1 city2 link ) False