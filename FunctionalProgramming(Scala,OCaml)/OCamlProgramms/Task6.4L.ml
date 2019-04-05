 type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let llist1 = LCons('a', function() -> LCons('b', function() -> LCons('c', function() -> LCons('d',function() ->  LCons('e', function() -> LNil)))));;
let llist2 = LCons('A', function() -> LCons('B', function() -> LCons('C', function() -> LNil)));;

let lshuffle (llist1,llist2) =
	let rec helper (lx1, lx2) =
		match (lx1,lx2) with
		| (LCons(head1, tailfun1), LCons(head2, tailfun2)) -> LCons(head1, function() -> LCons(head2, function() -> helper(tailfun1(),tailfun2())))
		| (LNil, LCons(head2, tailfun2)) -> LCons(head2, function () -> helper(LNil, tailfun2()))
		| (LCons(head1,tailfun1), LNil) -> LCons(head1, function () -> helper(LNil, tailfun1()))
		| (LNil, LNil) -> LNil
		in helper (llist1, llist2);;

let rec ltake = function 
	| (0, _) -> [] 
	| (_, LNil) -> [] 
	| (n, LCons(x,xf)) -> x::ltake(n-1, xf()) ;;

ltake (20,lshuffle (llist1,llist2));;