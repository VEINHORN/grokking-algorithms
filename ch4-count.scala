object Main extends App {
  def count(list: Seq[Int]): Int =
    if (list.isEmpty) 0 else 1 + count(list.tail)

  if (args.isEmpty) println(count(1 :: 2 :: 3 :: Nil))
  else println(count(args.map(_.toInt)))
}
