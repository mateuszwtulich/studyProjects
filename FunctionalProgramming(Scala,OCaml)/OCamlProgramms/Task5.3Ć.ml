type 'a lBT = LEmpty  |  LNode of  'a * (unit ->'a lBT) * (unit -> 'a lBT);; 
type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let rec ltake = function 
	| (0, _) -> [] 
	| (_, LNil) -> [] 
	| (n, LCons(x,xf)) -> x::ltake(n-1, xf()) ;;

let rec lTree n =
LNode(n, (function () -> lTree (2 * n)), function () -> lTree (2 * n + 1));;

let rec breadthBT tree =
	let rec helper queue = 
		match queue with
	| [] -> LNil
	| LEmpty::tail -> helper tail
	| LNode(value,left,right)::tail -> LCons (value, function () -> helper (tail@[left(); right()]))
in helper[tree];;

ltake (15, breadthBT (lTree 3));;