module type POJEMNIK = 
	sig   
		type 'a t
		exception Empty of string
		exception Full of string   
		val create: unit -> 'a t   
		val put: 'a * 'a t -> unit   
		val get: 'a t -> 'a  
		end;;

module Pojemnik': POJEMNIK = 
	struct   
		type 'a option = Empty  |  Element of 'a
		type 'a t = { mutable t : 'a option } 
		
		exception Empty of string
		exception Full of string 
  
	let create() = { t = Empty} 
	
	let put(e,p) = 
		match p.t with
		| Empty -> p.t <- Element e
		| Element e -> raise (Full "Pojemnik")  
	
	let get p =
		match p.t with
		| Element e -> p.t <- Empty; e
		| Empty -> raise (Empty "Pojemnik")                               
end;;

module PojemnikList: POJEMNIK= 
	struct   
	type 'a t = { mutable l : 'a list }
		exception Empty of string
		exception Full of string 
		
	let create() = { l = [] }
		
	let put(e,p) = 
		match p.l with
	| [] -> p.l <- e :: p.l
	| _ ->  raise (Full "Pojemnik")  
	
	let get p =     
		match p.l with       
	| hd::_ -> p.l <- []; hd     
	| []     -> raise (Empty "Pojemnik") 
end;; 


let p = PojemnikList.create();;
PojemnikList.put(2,p);;
PojemnikList.put(4,p);;
PojemnikList.get(p);;

let x = Pojemnik'.create();
Pojemnik'.put(2,x);;
Pojemnik'.put(4,x);;
Pojemnik'.get(x);;