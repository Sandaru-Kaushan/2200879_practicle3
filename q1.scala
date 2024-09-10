class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator must be non-zero")

  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1)

  def neg: Rational = new Rational(-numer, denom)

  def +(that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def -(that: Rational): Rational =
    new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )

  def *(that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  def /(that: Rational): Rational =
    new Rational(numer * that.denom, denom * that.numer)

  override def toString: String = s"$numer/$denom"

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}

object RationalTest extends App {
  val x = new Rational(3, 4)
  println(s"x = $x")
  println(s"-x = ${x.neg}")

  val y = new Rational(5, 7)
  println(s"y = $y")
  println(s"x + y = ${x + y}")
  println(s"x - y = ${x - y}")
  println(s"x * y = ${x * y}")
  println(s"x / y = ${x / y}")
}
