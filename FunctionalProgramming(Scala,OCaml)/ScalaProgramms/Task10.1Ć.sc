class UnderflowException(msg: String) extends Exception(msg)

class MyQueue[+T] private(private val queue: (List[T],List[T])){

  def enqueue[S >: T](elem: S): MyQueue[S] = queue match {
    case (Nil, endOfqueue) => new MyQueue(elem :: endOfqueue.reverse, Nil)
    case (first, second) => new MyQueue(first, elem :: second)
  }

  def dequeue: MyQueue[T] = queue match {
    case (Nil, _) => throw new UnderflowException("Empty queue")
    case (_::tail, endOfQueue) => if(tail == Nil)new MyQueue(endOfQueue.reverse, Nil)
    else new MyQueue(tail, endOfQueue)
  }

  def first: T = queue match {
    case (Nil,_) => throw new UnderflowException("Empty queue")
    case (hd ::_,_) => hd
  }

  def isEmpty : Boolean =
    queue._1 == Nil

  def toList = queue._1 ++ (queue._2).reverse

}

  object MyQueue {
  def apply[T](xs: T*) = new MyQueue[T](xs.toList, Nil)
  def empty[T] = new MyQueue[T](Nil,Nil)
}

class Point( var x:Double = 0.0, var y:Double = 0.0 )
{
  override def toString = "[" + x + ", " + y + "]"
}

import java.awt.Color
class Pixel( xp:Double=0.0, yp:Double=0.0, var color:Color= Color.BLACK )
  extends Point(xp, yp)
{
  override def toString= super.toString+ " " + color
}

var queueOfPoints = MyQueue(new Point)
val queueOfPoints1 = queueOfPoints.enqueue(new Pixel(1,2))
queueOfPoints1.first.asInstanceOf[Pixel]
val queueOfPixels = MyQueue(new Pixel(2,3))
  queueOfPoints = queueOfPixels

var myqueueOfPoints = MyQueue(new Point())
val myqueueOfPixels = MyQueue(new Pixel(2,3))
  myqueueOfPoints = myqueueOfPixels

myqueueOfPoints.first