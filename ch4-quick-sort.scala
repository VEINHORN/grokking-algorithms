object Main extends App {
  def quickSort(seq: Seq[Int]): Seq[Int] = {
    def pivot = seq(0)

    def split(pivot: Int) = seq.foldLeft((Seq.empty[Int], Seq.empty[Int], Seq.empty[Int])) {
      case ((l, e, g), num) if num == pivot => (l, e :+ num, g)
      case ((l, e, g), num) if num < pivot => (l :+ num, e, g)
      case ((l, e, g), num) => (l, e, g :+ num)
    }
   
    if (seq.length < 2) {
      seq
    } else {
      val splitted = split(pivot)
      quickSort(splitted._1) ++ splitted._2 ++ quickSort(splitted._3)
    }
  }

  println(quickSort(3 :: 1 :: 2 :: 4 :: 10 :: 7 ::Nil).mkString(" "))
}
