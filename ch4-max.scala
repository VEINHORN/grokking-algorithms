import scala.math

object Main extends App {
  def max(seq: Seq[Int]): Int =
    if (seq.isEmpty) -1 else math.max(seq.head, max(seq.tail))
   
  println(max(2 :: 4 :: Nil))
  println(max(6 :: 5 :: Nil))
  println(max(Seq()))
}
