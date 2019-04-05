class IllegalArgumentException(msg: String) extends Exception(msg)

class Time(h: Int = 0, m: Int = 0) {
  private var minutes: Int = (h*60 + m)

  if (h < 0 || h >= 24) {throw new IllegalArgumentException("wrong hour argument!"); minutes = 0}
  else if (m < 0 || m >= 60) {throw new IllegalArgumentException("wrong minute argument!"); minutes = 0}

  def hour: Int = (minutes/60)

  def hour_=(newHour:Int) : Unit = {
    if (newHour < 0 || newHour >= 24) throw new IllegalArgumentException("wrong hour argument!") else minutes = ((minutes%60) + newHour*60)
  }

  def minute: Int = (minutes%60)

  def minute_=(newMinute:Int): Unit = {
    if (newMinute < 0 || newMinute >= 60) throw new IllegalArgumentException("wrong minute argument!") else minutes = (newMinute + (minutes/60)*60)
  }

  def before(other: Time): Boolean = if (minutes < other.minutes) true else false
}

object Time{
  def apply(h: Int, m: Int): Time = new Time(h, m);
}

val t1 = new Time(2,56)
t1.hour
t1.minute
t1.hour = 2
t1.minute = 58
t1.hour
t1.minute

val t2 = new Time(2,57)
t1.before(t2)
t2.before(t1)


