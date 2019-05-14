object Functor {

  def stringLength(str: String): Int = str.length
  def isEven(num: Int): Boolean = num % 2 == 0
  def toString(num: Int): String = num.toString

  trait Functor[F[_]] {
    def map[A, B] (f: A=>B) (v: F[A]) => F[B]
  }
}
