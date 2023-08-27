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
foundR region@(Reg citiesReg linksReg tunelsReg) newcity
   | cityValid region newcity = Reg ( newcity : citiesReg ) linksReg tunelsReg 
   | otherwise = error "Ya existe esa ciudad"

cityValid :: Region -> City -> Bool
cityValid (Reg citiesReg _ _) newcity = 
   notElem newcity citiesReg && 
   foldr (\cityR fold -> fold && (nameC cityR /= nameC newcity) && (distanceC cityR newcity /= 0) )  True citiesReg

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR region@(Reg citiesReg linksReg tunelsReg) city1 city2 calidad = 
   if elem city1 citiesReg && elem city2 citiesReg && not (linkedR region city1 city2) 
      then Reg citiesReg ( newL city1 city2 calidad : linksReg) tunelsReg 
      else error "No se puede crear este link, no existen las ciudades o ya existe el link"


tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR region@(Reg citiesReg linksReg tunelsReg) citiesT = 
   if linksvalidos region (ciudadespar citiesT) 
      then Reg citiesReg linksReg (newT [linkentre linksReg city1 city2 | [city1, city2] <- ciudadespar citiesT ]:tunelsReg) 
      else error "No se puede crear este Tunel, hay ciudades que no estan entrelazadas"

linkentre :: [ Link ] -> City -> City -> Link
linkentre [] _ _ = error "No existe el link"
linkentre (link:links) city1 city2 
    | linksL city1 city2 link = link
    | otherwise = linkentre links city1 city2 

ciudadespar :: [ City ] -> [ [ City ] ]
ciudadespar [ city1 , city2 ] = [[ city1 , city2 ]]
ciudadespar ( city1 : ( city2 : cities)) = [ city1 , city2 ] : ciudadespar ( city2 : cities)

linksvalidos :: Region -> [ [ City ] ] -> Bool
linksvalidos region = foldr (\[city1 , city2] fold -> fold && (linkedR region city1 city2 && (availableCapacityForR region city1 city2 > 0))) True 


connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg citiesReg linksReg tunelsReg) city1 city2 = foldr ((||).connectsT city1 city2) False tunelsReg


linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg citiesReg linksReg tunelsReg) city1 city2 = foldr ((||).linksL city1 city2) False linksReg


delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg citiesReg linksReg tunelsReg) city1 city2 = delayT (tunelentre tunelsReg city1 city2)

tunelentre :: [ Tunel ] -> City -> City -> Tunel
tunelentre [] _ _ = error "No existe el tunel"
tunelentre (tunel:tunels) city1 city2 
    | connectsT city1 city2 tunel = tunel
    | otherwise = tunelentre tunels city1 city2 


availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg citiesReg linksReg tunelsReg) city1 city2 =  capacidadlinks - cantidadtuneles
   where 
      link = linkentre linksReg city1 city2
      capacidadlinks = capacityL link
      cantidadtuneles = foldr (\_ -> (+) 1) 0 [tunel | tunel <- tunelsReg, usesT link tunel]
