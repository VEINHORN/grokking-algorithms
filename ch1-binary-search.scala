import scala.util.control.Breaks._

object Main {
  def main(args: Array[String]) = {
    val array = Array(1, 3, 7, 10, 14) 
    
    println(binarySearch(array, 1))
    println(binarySearch(array, 3))
    println(binarySearch(array, 7))
    println(binarySearch(array, 10))
    println(binarySearch(array, 14))
    
    println(binarySearch(array, 2))
    println(binarySearch(Array(), 0))
  }

  def binarySearch(array: Array[Int], value: Int): Option[Int] = {
    var left = 0
    var right = array.length - 1

    var index: Option[Int] = None
    breakable {
      var j = 1
      while (left <= right) {
        val guess = (right + left) / 2

        if (value == array(guess)) {
          index = Some(guess); break
        } else if (value < array(guess)) {
          right = right - 1 - (right - left) / 2
        } else if (value > array(guess)) {
          left = left + 1 + (right - left) / 2
        }
      }
    }

    index
  }

}
