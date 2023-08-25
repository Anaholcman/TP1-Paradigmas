module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR )
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
foundR (Reg citiesReg linksReg tunelsReg) newcity = if notElem newcity citiesReg then Reg ( newcity : citiesReg ) linksReg tunelsReg else error "Ya existe esa ciudad"
--hay que ver que no este en el mismo lugar que otra ciudad

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR region@(Reg citiesReg linksReg tunelsReg) city1 city2 calidad = if elem city1 citiesReg && elem city2 citiesReg && not linkedR region city1 city2 then Reg citiesReg ( newL city1 city2 calidad : linksReg) tunelsReg 

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR region@(Reg citiesReg linksReg tunelsReg) citiesT = if esvalido region (ciudadespar citiesT) then Reg citiesReg linksReg (newT (linksentre region (ciudadespar citiesT)):tunelsReg) else error "No se puede crear este Tunel, hay ciudades que no estan entrelazadas"

linksentre :: [ Link ] -> [ [ City ] ] -> [ Link ]
linksentre linksReg [] = []
linksentre linksReg ( [city1,city2] : cities) = [if linksL city1 city2 link then link | link <- linksReg] ++ (linksentre linksReg ( city2 : cities))

ciudadespar :: [ City ] -> [ [ City ] ]
ciudadespar [ city1 , city2 ] = [[ city1 , city2 ]]
ciudadespar ( city1 : ( city2 : cities)) = ([ city1 , city2 ] : ciudadespar ( city2 : cities))

esvalido :: Region -> [ [ City ] ] -> Bool
esvalido region cities = foldr (\[city1 , city2] -> (&&).(linkedR region city1 city2 && (availableCapacityForR region city1 city2 > 0))) True cities

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg citiesReg linksReg tunelsReg) city1 city2 = foldr ((||).(connectsT city1 city2)) False tunelsReg

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg citiesReg linksReg tunelsReg) city1 city2 = foldr ((||).(linksL city1 city2)) False linksReg

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delay (Reg citiesReg city1 city2) = foldr ( (+).delayL ) 0.0 city1 
-- suma del delay de cada link

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR _ _ _ = 0
-- revisar todos los links existentes entre las ciudades, sumar la capacidad y restar la cantidad de tuneles que pasan