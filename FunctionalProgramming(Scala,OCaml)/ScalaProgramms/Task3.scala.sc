sealed trait BT[+A]
case object Empty extends BT[Nothing]
case class Node[+A](elem:A, left:BT[A], right:BT[A]) extends BT[A]

val tree = Node(1, Node(2, Node(4, Empty, Empty ), Empty ), Node(3, Node(5, Empty, Node(6, Empty, Empty ) ), Empty ) )

def breadthBT[A] (tree: BT[A]) = {
  def helper[A](xs: List[BT[A]]): List[A] =
    xs match {
      case Nil => Nil
      case Empty :: tail => helper(tail)
      case Node(value, left, right) :: tail => value :: helper(tail ++ List(left, right))
    }
  helper (List(tree))
}

breadthBT (tree)