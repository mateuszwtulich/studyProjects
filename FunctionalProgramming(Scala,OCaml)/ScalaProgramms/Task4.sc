sealed trait BT[+A]
case object Empty extends BT[Nothing]
case class Node[+A](elem:A, left:BT[A], right:BT[A]) extends BT[A]

val tree = Node(1, Node(2, Node(4, Empty, Empty ), Empty ), Node(3, Node(5, Empty, Node(6, Empty, Empty ) ), Empty ) )

def internalLen[A] (tree: BT[A]) = {
  def helper[A](tree: BT[A], acc: Int, x: Int): Int =
    tree match {
      case Node(v, Empty, Empty) => acc
      case Node(v, left, Empty) => helper(left, x + acc, x + 1)
      case Node(v, Empty, right) => helper(right, x + acc, x + 1)
      case Node(v, left, right) => helper(left, x + acc, x + 1) + helper(right, x + acc, x + 1)
    }
  helper(tree, 0, 1)
}

internalLen (tree)

def externalLen[A] (tree:BT[A]) = {
  def helper[A](tree:BT[A], acc:Int):Int =
    tree match {
      case Empty => acc
      case Node(v, left, right) => helper(left, 1 + acc) + helper(right, 1 + acc)
    }
  helper (tree, 0)
}

externalLen (tree)