let lollies = [|5;7;4;6;1;3;5|];;
let delay =   [|3;2;3;5;1;2;5|];;

let lolliesProblem (lollies, delay) = 
	let array = Array.make (Array.length lollies) 0 and x = ref 0 and max = ref 0 and previous = ref 0 in
	for i = 1 to Array.length lollies do x := (Array.length lollies - i); max := 0;
	while (!x < Array.length lollies) do 
	max := !max +  Array.get lollies !x;
	x := !x + Array.get delay !x; done;
	if !previous > !max then max:= !previous;
	previous := !max;
	Array.set array (Array.length lollies - i) !max done; array;;

let whichDayToStart array = let g (acc, y) x = if y < x then (acc+1, x) else (acc, y) in
match Array.fold_left g (0, 0) array with
|(acc,_) -> acc;;

let rec pathToMax dayToStart = 
	if dayToStart < Array.length delay then dayToStart::pathToMax(dayToStart + Array.get delay (dayToStart-1)) else [];;

let array = lolliesProblem (lollies, delay);;
let dayToStart = whichDayToStart array;;
lolliesProblem (lollies, delay);;
whichDayToStart array;;
pathToMax dayToStart;;