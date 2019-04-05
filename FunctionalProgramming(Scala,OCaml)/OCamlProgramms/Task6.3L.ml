 type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let llist = LCons(1, function() -> LCons(2, function() -> LCons(3, function() -> LCons(4,function() -> LNil))));;

let onlyModulo (llist, x) =
	let rec helper lx =
		match lx with
		| LCons(head, tailfun) -> if head mod x = 0 then LCons(head, function () -> helper(tailfun())) else helper(tailfun())
		| LNil -> LNil
	in helper llist;;

let rec ltake = function 
	| (0, _) -> [] 
	| (_, LNil) -> [] 
	| (n, LCons(x,xf)) -> x::ltake(n-1, xf()) ;;

ltake (4 ,onlyModulo (llist, 2));;