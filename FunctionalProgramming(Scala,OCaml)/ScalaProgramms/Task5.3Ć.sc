sealed trait lBT[+A]
case object LEmpty extends lBT[Nothing]
case class LNode[+A](elem:A, left:()=>lBT[A], right:()=>lBT[A]) extends lBT[A]

def lTree(n: Int): lBT[Int] =
  LNode(n, () => lTree(2 * n), () => lTree(2 * n + 1))

def breadthBT[A] (tree: lBT[A]):Stream[A]= {
  def helper[A](queue: List[lBT[A]]): Stream[A] =
    queue match {
      case Nil => Stream.Empty
      case LEmpty :: tail => helper(tail)
      case LNode(value, left, right) :: tail => value #:: helper(tail ++ List(left(), right()))
    }
  helper (List(tree))
}

breadthBT(lTree (3)).take(15).toList
