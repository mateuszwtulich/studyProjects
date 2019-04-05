let g (x,bool)y = if bool = true then (y,(x<=y)) else (y,false);;

let y xs = 
	match List.fold_left g (0,true) xs with
	| (_, y) -> y;;

let tylkoNiemalejace xss = List.filter y xss;;

let xss = [1::1::3::[];2::4::6::1::[];1::1::1::[];3::4::1::[];[]];;

tylkoNiemalejace xss;;