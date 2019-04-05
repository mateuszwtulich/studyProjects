type 'a bt = Empty | Node of 'a * 'a bt * 'a bt;;

let tree = Node(1,Node(2,Node(4,Empty,Empty),Empty),Node(3,Node(5,Empty,Node(6,Empty,Empty)),Empty));;

let listOfPath tree =
	let rec helper (subTree, current, xs) =
		match subTree with
		| Empty -> current::xs
		| Node(value, leftSub, rightSub) -> helper(leftSub, 1 + current, xs) @ helper(rightSub, 1 + current, xs)
		in helper(tree, 0, []);;
		
		
let f x y = if x < y then y else x;;

let height tree = List.fold_left f 0 (listOfPath tree);;

height tree;;