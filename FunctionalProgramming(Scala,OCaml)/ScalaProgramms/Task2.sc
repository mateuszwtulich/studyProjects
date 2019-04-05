def podzielPoN[A] (xs: List[A], length: Int): (List[A],List[A]) = {
  if (xs == Nil) (Nil, Nil)
  else if (length <= 0) (Nil, Nil)
  else if (length >= xs.length)(xs, Nil)
  else {
    def podzielPoN1[A](xs: List[A], x: Int, ys: List[A]): (List[A], List[A]) =
     x match{
       case 0 => (ys.reverse, xs)
       case _ => podzielPoN1(xs.tail, x - 1, xs.head :: ys)
     }
    podzielPoN1 (xs, length, Nil)
  }
}

val xs = 1::2::3::4::5::6::7::Nil;;

podzielPoN (xs, 6);;