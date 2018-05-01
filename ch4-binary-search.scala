object Main extends App {
  def binarySearch(arr: Seq[Int], value: Int): Int = {
    def search(arr: Seq[Int], value: Int)(left: Int, right: Int): Int =
      if (value == arr( (left + right) / 2) ) (left + right) / 2
      else if (value < arr( (left + right) / 2 ) ) search(arr, value)(left, right - 1 - (right - left) / 2)
      else search(arr, value)(left + 1 + (right - left) / 2, right)

    if (arr.isEmpty) -1 else search(arr, value)(0, arr.length - 1)
  }

  println( binarySearch(1 :: 3 :: 7 :: 9 :: 14 :: Nil, 9) )
  println( binarySearch(1 :: 3 :: 7 :: 9 :: 14 :: Nil, 3) )
}
