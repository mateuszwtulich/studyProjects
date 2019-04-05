let createArray (x,y) = Array.init x (function i -> Array.make y 0);;

let matrix = createArray (7,4);;

let showMatrix matrix = 
	for i=0 to Array.length matrix - 1 do
		for j=0 to Array.length matrix.(0) - 1 do print_int (Array.get matrix.(i) j); print_string " " done;
		print_newline() done;;

let setOne matrix = 
	for i=0 to Array.length matrix.(0) - 1 do Array.set matrix.(0) i 1; Array.set matrix.(Array.length matrix - 1) i 1 done;
	for k=1 to (Array.length matrix - 2) do Array.set matrix.(k) 0 1; Array.set matrix.(k) (Array.length matrix.(0) - 1) 1 done;;

Array.set matrix.(1) 2 4;;
showMatrix matrix;;
setOne matrix;;
showMatrix matrix;;
