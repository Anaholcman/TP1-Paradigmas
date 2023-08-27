import Point ( Point, newP, difP)
import City ( City, newC, nameC, distanceC ) 
import Quality ( Quality, newQ, capacityQ, delayQ )
import Link ( Link, newL, linksL, connectsL, capacityL, delayL )
import Tunel ( Tunel, newT, connectsT, usesT, delayT )      
import Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR)

punto1 = newP 1 2  
punto2 = newP 5 5

ciudad1 = newC "BsAs" punto1
ciudad2 = newC "caba" punto2
ciudad3 = newC "mardel" (newP 2 1)

calidad = newQ "cobre" 5 1.5  

link1 = newL ciudad1 ciudad2 calidad
link2 = newL ciudad2 ciudad3 calidad
link3 = newL ciudad1 ciudad3 calidad

tunel1 = newT [link1,link2]

crearReg :: [ City ] -> [[ City ]] -> [[ City ]] -> Region
crearReg cities links = foldl tunelR (foldl (\fold [city1, city2] -> linkR fold city1 city2 calidad) (foldl foundR newR cities) links)

region = crearReg [ciudad1, ciudad2, ciudad3] [[ciudad1, ciudad2], [ciudad2, ciudad3]] [[ciudad1, ciudad2, ciudad3]]

t = [ difP punto1 punto2 == 5.0 , 

      nameC ciudad1 == "BsAs"  ,
      distanceC ciudad1 ciudad2 == 5.0 , 

      capacityQ calidad == 5 , 
      delayQ calidad == 1.5 , 

      linksL ciudad1 ciudad2 link1, 
      not (linksL ciudad1 ciudad2 link2), 
      connectsL ciudad2 link1, 
      not (connectsL ciudad3 link1), 
      capacityL link1 == 5, 
      delayL link1 == 7.5 ,

      connectsT ciudad1 ciudad3 tunel1,
      not (connectsT ciudad1 ciudad2 tunel1),
      usesT link1 tunel1, 
      not (usesT link3 tunel1),
      delayT tunel1 == 15.0,

      connectedR region ciudad1 ciudad3,
      not (connectedR region ciudad1 ciudad2),
      linkedR region ciudad1 ciudad2,
      not (linkedR region ciudad1 ciudad3),
      delayR region ciudad1 ciudad3 == 15.0,
      availableCapacityForR region ciudad1 ciudad2 == 4,

      True]
      
{- Testeos que tienen que tirar error

ghci> foundR region ciudad1

*** Exception: Ya existe esa ciudad
CallStack (from HasCallStack):
  error, called at ./Region.hs:19:12 in main:Region

ghci> linkR region ciudad1 ciudad2 calidad

*** Exception: No se puede crear este link, no existen las ciudades o ya existe el link
CallStack (from HasCallStack):
  error, called at ./Region.hs:22:228 in main:Region
 
ghci> tunelR region [ciudad1,ciudad3]

*** Exception: No se puede crear este Tunel, hay ciudades que no estan entrelazadas
CallStack (from HasCallStack):
  error, called at ./Region.hs:28:12 in main:Region
 
ghci> delayR region ciudad1 ciudad2

*** Exception: No existe el tunel
CallStack (from HasCallStack):
  error, called at ./Region.hs:53:21 in main:Region
 
ghci> availableCapacityForR region ciudad1 ciudad3

*** Exception: No existe el link
CallStack (from HasCallStack):
  error, called at ./Region.hs:31:20 in main:Region

-}