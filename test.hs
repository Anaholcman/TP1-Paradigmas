import Point ( Point, newP, difP)
import City ( City, newC, nameC, distanceC ) 
import Quality ( Quality, newQ, capacityQ, delayQ )
import Data.Binary (decode)
import Link ( Link, newL, linksL, connectsL, capacityL, delayL )
-- import Tunel ( Tunel, newT, connectsT, usesT, delayT )      

punto1 = newP 5 5 
punto2 = newP 1 2
ciudad1 = newC "BsAs" punto1
ciudad2 = newC "caba" punto2
calidad = newQ "cobre" 5 1.5  
link1 = newL ciudad1 ciudad2 calidad
t = [ difP punto1 (newP 1 2) == 5.0 , 
      nameC ciudad1 == "BsAs"  ,
      distanceC ciudad1 ciudad2 == 5.0 , 
      capacityQ calidad == 5 , 
      delayQ calidad == 1.5 , 
      linksL ciudad1 ciudad2 link1, 
      connectsL ciudad2 link1, 
      capacityL link1 == 5, 
      delayL link1 == 7.5 ,
      True]


-- stickWith :: [Int] -> Stick
-- stickWith = foldr (\each fold -> push fold each) Vacio

-- initWith :: [Int] -> [Int] -> [Int] -> Hanoi
-- initWith i c d = Hanoi (stickWith i) (stickWith c) (stickWith d)

-- hanoi = initWith [] [1,3] [2]

-- t = [ pop ( Stack Vacio 2) == Vacio,
--       push Vacio 3 == Stack Vacio 3,
--       top (push Vacio 3) == 3,
--       stickWith [ 2, 3 ] == Stack (Stack Vacio 3) 2,
--       True ]