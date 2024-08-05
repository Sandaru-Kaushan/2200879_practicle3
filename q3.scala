object filterPrime{
def isPrime(n: Int): Boolean = {
  if (n <= 1) false
  else if (n == 2) true
  else !(2 until n).exists(i => n % i == 0)
}

def filterPrime(numbers: List[Int]): List[Int] = {
  numbers.filter(num => isPrime(num))
}

def main(args:Array[String]):Unit={
val input = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
val output = filterPrime(input)
println(output) // Output: List(2, 3, 5, 7)
}
}