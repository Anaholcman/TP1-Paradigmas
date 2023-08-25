import Point ( Point, newP, difP)
import City ( City, newC, nameC, distanceC ) 
import Quality ( Quality, newQ, capacityQ, delayQ )
import Data.Binary (decode)
import Link ( Link, newL, linksL, connectsL, capacityL, delayL )
import Tunel ( Tunel, newT, connectsT, usesT, delayT )      
-- import Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR )

punto1 = newP 5 5 
punto2 = newP 1 2
ciudad1 = newC "BsAs" punto1
ciudad2 = newC "caba" punto2
ciudad3 = newC "mardel" (newP 3 2)
calidad = newQ "cobre" 5 1.5  
link1 = newL ciudad1 ciudad2 calidad
link2 = newL ciudad2 ciudad3 calidad
tunel = newT [link1,link2]

t = [ difP punto1 (newP 1 2) == 5.0 , 
      nameC ciudad1 == "BsAs"  ,
      distanceC ciudad1 ciudad2 == 5.0 , 
      capacityQ calidad == 5 , 
      delayQ calidad == 1.5 , 
      linksL ciudad1 ciudad2 link1, 
      connectsL ciudad2 link1, 
      capacityL link1 == 5, 
      delayL link1 == 7.5 ,
      not (connectsT ciudad1 ciudad2 tunel), 
      connectsT ciudad1 ciudad3 tunel,
      usesT link1 tunel, 
      True]


