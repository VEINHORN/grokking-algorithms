object Main {
  def main(args: Array[String]) = {
    println(bubbleSort(Array(5, 2, 3, 6, 7, 10)).mkString(" "))
    println(bubbleSort(Array(10, 1)).mkString(" "))

    println(bubbleSort(Array()).mkString(" "))
  }

  def bubbleSort(array: Array[Int]) = {
    var i = 0

    while (i < array.length) {
      var j = 1

      while (j < array.length) {
        if (array(j - 1) > array(j)) {
          val tmp = array(j - 1)
          array(j - 1) = array(j)
          array(j) = tmp
        }

        j += 1
      }

      i += 1
    }

    array
  }
}
