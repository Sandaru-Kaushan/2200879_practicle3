object RationalSubtraction {
  
  case class Rational(numerator: Int, denominator: Int) {
    require(denominator != 0, "Denominator cannot be zero")

    def -(that: Rational): Rational = {
      val commonDenominator = this.denominator * that.denominator
      val newNumerator = this.numerator * that.denominator - that.numerator * this.denominator
      Rational(newNumerator, commonDenominator).reduce()
    }

    def reduce(): Rational = {
      val gcdValue = gcd(numerator, denominator)
      Rational(numerator / gcdValue, denominator / gcdValue)
    }

    private def gcd(a: Int, b: Int): Int = {
      if (b == 0) a else gcd(b, a % b)
    }

    override def toString: String = s"$numerator/$denominator"
  }

  def main(args: Array[String]): Unit = {
    val x = Rational(3, 4)
    val y = Rational(5, 8)
    val z = Rational(2, 7)

    val result = (x - y) - z
    println(s"The result of x - y - z is: $result")
  }
}
