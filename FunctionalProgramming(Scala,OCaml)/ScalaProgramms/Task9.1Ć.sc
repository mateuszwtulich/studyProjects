class Osoba(pes: Int, naz:String , pen:Int){
  private val pesel: Int = f(pes)
  var nazwisko: String = naz
  protected var pensja: Int = pen

  private def nty (n:Int): Int  = {
    def helper(n: Int,result: Int ): Int =
      n match {
        case 0 => result
        case _ => helper(n-1, 10 * result)
      }
    helper(n-1, 10)
  }

  private def f(x: Int): Int = {
    def helper(x: Int, y: Int, n: Int): Int =
      x match {
        case 0 => y
        case _ => helper(x / 10, (((x % 10) + 1) * nty(n) + y), n+1)
      }
    helper(x / 10, (x % 10) + 1, 1)
  }


  def this(pes: Int) = {
      this(pes, "brak", 2000)
    }

  def this(pes: Int, naz: String){
    this(pes, naz, 2000)
  }

  def zarobki() = pensja

  override def toString = "Osoba: pesel = " + pesel + ", nazwisko = " + nazwisko + ", pensja = " + pensja

  def getPesel() = pesel

}

class Specjalista(oPes: Int, oNaz: String, oPen: Int, prem: Int = 1000) extends Osoba(oPes, oNaz, oPen) {
  protected var premia:Int = prem

   override def zarobki() = super.zarobki() + premia

   override def toString = super.toString + ", premia = " + premia
}

var spec1 = new Specjalista(23123, "kowal" , 2500, 1500)
var osoba1 = new Osoba(23344, "kowalski", 2500)
var osoba2 = new Osoba(24124, "nowak")
var osoba3 = new Osoba(23012)

val lista: List[Osoba] = List(osoba1, osoba2, osoba3, spec1);

def show (list: List[Osoba]) : Unit =
list match {
  case h::t => println(h.toString); show(t)
  case Nil => Unit
}

def zarobkiWszystkich(list: List[Osoba]) : Int = {
  def helper(list: List[Osoba], suma: Int) :Int =
    list match {
      case h :: t => helper(t, suma + h.zarobki())
      case Nil => suma
    }
    helper(list, 0)
  }

show(lista)
zarobkiWszystkich(lista)