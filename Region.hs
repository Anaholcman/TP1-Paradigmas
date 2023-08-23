module Region ( Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
   where

import Point ( Point, newP, difP)
import City ( City, newC, nameC, distanceC ) 
import Quality ( Quality, newQ, capacityQ, delayQ )
import Link ( Link, newL, linksL, connectsL, capacityL, delayL )
import Tunel ( Tunel, newT, connectsT, usesT, delayT )      

data Region = Reg [City] [Link] [Tunel]

newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg citiesReg linksReg tunelsReg) newcity = if not (elem newcity citiesReg) then Reg (newcity:citiesRegs) linksReg tunelsReg else error "Ya existe esa ciudad"

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunels) city1 city2 calidad = Reg cities ((newL city1 city2 calidad):links) tunels --revisar q las citis esten en la region

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg citiesR linksR tunels) citiesT = Reg citiesR links (newT (linksentre citiesT linksR):tunels)

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg citiesReg linksReg tunelsReg) city1 city2 = foldr ((||).connectsL city1 city2) False linksReg

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades

linksentre :: [ City ] -> [ Link ] -> [ Link ]
linksentre ( city1 : ( city2 : cities)) [] = error "primero hay que crear los links entre las ciudades"
linksentre [] linksReg = []


linksentre ( city1 : ( city2 : cities)) linksReg = [if linksL city1 city2 link then link | link <- linksReg] ++ (linksentre ( city2 : cities) linksReg)

