val s = Stream.cons(1,Stream.cons(2,Stream.cons(3,Stream.cons(4,Stream.empty))))

def lrepeat[A] (k:Int, stream:Stream[A]):Stream[A] = {
  def helper[A](times: Int, lxs: Stream[A]): Stream[A] =
    (times, lxs) match{
      case (_, Stream.Empty) => Stream.Empty
      case (0, _#::tail) => helper(k, tail)
      case (_, head#::_) => head#::(helper(times - 1, lxs))
  }
  helper(k, stream)
}

lrepeat(4, s) toList
