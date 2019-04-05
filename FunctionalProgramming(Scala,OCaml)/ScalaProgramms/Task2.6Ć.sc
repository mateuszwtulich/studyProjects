val  xs:List[Char] = 'p'::'o'::'l'::'a'::'k'::Nil

def replaceNth[A] (xs: List[A], number: Int, elem: A): List[A] =
  if (number < 0|| number > xs.length) xs
  else if (xs == Nil) Nil
else {
  number match{
      case 0 => elem :: xs.tail
      case _ => xs.head :: replaceNth(xs.tail, number - 1, elem)
  }
}
replaceNth(xs, 0, 'k')
replaceNth(xs, 4, 'p')
replaceNth(xs, 2, 'i')
