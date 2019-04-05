sealed trait BT[+A]
case object Empty extends BT[Nothing]
case class Node[+A](elem:A, left:BT[A], right:BT[A]) extends BT[A]

  val tree = Node(1, Node(2, Node(4, Empty, Empty), Empty), Node(3, Node(5, Empty, Node(6, Empty, Empty)), Empty))

  def listOfPath[A](tree: BT[A]): List[Int] = {
    def helper[A](subTree: BT[A], current: Int, xs: List[Int]): List[Int] =
      subTree match {
        case Empty => current :: xs
        case Node(value, leftSub, rightSub) => helper(leftSub, 1 + current, xs) ++ helper(rightSub, 1 + current, xs)
      }
    helper(tree, 0, Nil)
  }

def height[A] (tree: BT[A]) : Int = (listOfPath(tree) foldLeft 0) ((x,y)=> if (x < y) y else x)
height (tree)