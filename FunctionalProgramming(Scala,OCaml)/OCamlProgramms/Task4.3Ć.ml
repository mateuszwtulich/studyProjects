type 'a bt = Empty | Node of 'a * 'a bt * 'a bt;;

let tree = Node(1,Node(2,Node(4,Empty,Empty),Empty),Node(3,Node(5,Empty,Node(6,Empty,Empty)),Empty));;

let rec breadthBT tree =
	let rec helper queue = 
		match queue with
	| [] -> []
	| Empty::tail -> helper tail
	| Node(value,left,right)::tail -> value :: helper (tail@[left; right])
in helper[tree];;

breadthBT tree;;