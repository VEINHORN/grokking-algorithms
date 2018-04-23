object Main {
  def main(args: Array[String]) = {
    println(selectionSort(Array(5, 2, 3, 7, 6, 10), _ > _).mkString(" "))
    println(selectionSort(Array(10, 1)).mkString(" "))

    println(selectionSort(Array()).mkString(" "))
  }

  def selectionSort(array: Array[Int], comp: (Int, Int) => Boolean = _ < _): Array[Int] = {
    var i = 0

    while (i < array.length) {
      var j = i
      var found = j
      
      while (j < array.length) {
        if (comp(array(j), array(found))) found = j
        j += 1
      }
      
      val tmp = array(i)
      array(i) = array(found)
      array(found) = tmp
     
      i += 1
    }

    array
  }
}
