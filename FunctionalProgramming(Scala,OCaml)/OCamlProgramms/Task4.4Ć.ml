type 'a bt = Empty | Node of 'a * 'a bt * 'a bt;;

let tree = Node(1,Node(2,Node(4,Empty,Empty),Empty),Node(3,Node(5,Empty,Node(6,Empty,Empty)),Empty));;

let internalLen tree = 
	let rec helper (tree, depth) =
		match tree with
		| Empty -> 0
		| Node(v,left,right) -> depth + helper (left, depth + 1) + helper(right, depth + 1)
		in helper (tree, 0);;

internalLen tree;;

let externalLen tree = 
	let rec helper (tree, depth) =
		match tree with
		| Empty -> depth
		| Node(v,left,right) -> helper (left, 1 + depth) + helper(right, 1 + depth)
		in helper (tree, 0);;

externalLen tree;;