object Main {
  def main(args: Array[String]) = {
    if (args.length == 1) println(factorial(args(0).toInt))
    else println(factorial(5))
  }

  def factorial(n: Int): Int = if (n == 1) n else n * factorial(n - 1)
}
