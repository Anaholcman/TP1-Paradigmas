module Point ( Point, newP, difP)
   where
module City ( City, newC, nameC, distanceC )
   where
module Quality ( Quality, newQ, capacityQ, delayQ )
   where
module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
   where
module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where
module Region ( Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
   where

punto1 = Poi 5 5
punto2 = Poi 1 2
ciudad1 = Cit 'BsAs' punto1
ciudad2 = Cit 'caba' punto2

t = [   punto1 == newP 5 5 ,
        difP punto1 punto2 == 5.0 , 
        newC 'BsAs' punto1 == ciudad1 , 
        nameC ciudad1 == 'BsAs' ,
        distanceC ciudad1 ciudad2 == 5.0 , 
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