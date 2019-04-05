type 'a graph = Graph of ('a -> 'a list);;

let graph = Graph 
(function 
| 0 -> [3] 
| 1 -> [0;2;4] 
| 2 -> [1] 
| 3 -> [] 
| 4 -> [0;2] 
| n -> failwith ("Graph g: node "^string_of_int n^" doesn't exist") );;

let depthSearch (Graph graph) node =
	let rec helper (visited, stack) =
		match stack with
		| [] -> []
		| h::t -> if List.mem h visited then helper (visited,t) 
		else h::helper (h::visited,graph h @ t)
	in helper ([],[node]);;

depthSearch graph 4;;