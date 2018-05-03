import scala.annotation.tailrec

object Main extends App {
  def mergeSort(seq: Seq[Int]): Seq[Int] = {
    
    def mergeSort(seqs: (Seq[Int], Seq[Int])): Seq[Int] = {
      def merge(seq1: Seq[Int], seq2: Seq[Int]): Seq[Int] = {
        @tailrec
        def merge(seq1: Seq[Int], seq2: Seq[Int], total: Seq[Int]): Seq[Int] = seq1 -> seq2 match {
          case (Seq(), Seq()) | (_, Seq()) | (Seq(), _) => total ++ seq1 ++ seq2
          case (s1, s2) if s1.head >= s2.head => merge(s1, s2.tail, total :+ s2.head)
          case (s1, s2) if s1.head < s2.head => merge(s1.tail, s2, total :+ s1.head)
        }

        merge(seq1, seq2, Seq())
      }
      
      seqs match {
        case (Seq(), Seq()) | (Seq(), _) | (_, Seq()) => seqs._1 ++ seqs._2
        case (s1, s2) => merge(mergeSort(s1.splitAt(s1.length / 2)), mergeSort(s2.splitAt(s2.length / 2)))
      }
    }

    mergeSort(seq.splitAt(seq.length / 2))
}
  println(mergeSort(Seq(3, 1, 4, 8, 5)).mkString(" "))
}
