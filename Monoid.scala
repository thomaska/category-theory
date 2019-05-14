object Monoid {

  trait Monoid[A] {
      val id: A

      def compose(a: A, b: A): A
    }

  val intMonoid = new Monoid[Int] {
      val id = 0

      def compose(a: Int, b: Int): Int = a + b
    }

  val listSum = List(1, 2, 3, 4).fold(0)((a,b) => a + b)

  def foldNew[A](list: List[A], m:Monoid[A]): A = {
    list match => {
      case Nil => m.id
      case h::t => m.compose(h, foldNew(t, m))
    }
  }

  case class Crate(weight: Int, canBeStacked: Boolean)

  val crateMonoid = new Monoid[Crate] {

    override val id = Crate(0, true)

    override def compose(a: Crate, b: Crate) = {
      Crate(a.weight + b.weight, a.canBeStacked && b.canBeStacked)
    }
  }
}