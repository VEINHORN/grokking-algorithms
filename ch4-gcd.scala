import scala.math._

object Main {
  def main(args: Array[String]): Unit = {
    if (args.length == 2) {
      println(gcd(args(0).toInt, args(1).toInt))
    } else {
      println(gcd(24, 9))
    }
  }

  def gcd(a: Int, b: Int): Int = {
    max(a, b) % min(a, b) match {
      case res if res == 0 => min(a, b)
      case res => gcd(res, min(a, b))
    }
  }
}
