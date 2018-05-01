object Main extends App {
  def sum(array: Array[Int]): Int =
    if (array.isEmpty) 0 else array.head + sum(array.tail)

  if (args.nonEmpty) println(sum(args.map(_.toInt)))
  else println(sum(Array(2, 3, 5)))
}
