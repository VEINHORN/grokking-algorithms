import scala.annotation.tailrec

object Main extends App {
  class LinkedList[T] {
    private var root: Node = _
    private var _size: Int = 0

    def size: Int = _size

    def add(value: T): Unit = {
      if (root == null) {
        root = new Node(value, null, null)
      } else {
        root.next = new Node(value, root, null)
        root = root.next
      }
      _size += 1
    }

    def get(i: Int): T = {
      if (i >= 0 && i < size) leftNode(root, size - i - 1).value
      else throw new Exception("invalid index")
    }

    // we can just store reference to the head of list
    def head: T = {
      if (root == null) throw new Exception("list is empty") else leftNode(root, size - 1).value
    }

    def tail: LinkedList[T] = {
      val head = leftNode(root, size - 1)
      head.next.prev = null
      head.next = null
      _size -= 1
      this
    }

    @tailrec private def leftNode(node: Node, n: Int): Node =
      if (node == null) null
      else if (n == 0) node
      else leftNode(node.prev, n - 1)

    class Node(val value: T, var prev: Node, var next: Node)
  }
 
  // add some "require" methods

  // test "head" and "tail"
  var list = new LinkedList[Int]
  list.add(1)
  list.add(2)
  list.add(3)
  println (s"head = ${ list.head }, tail head = ${ list.tail.head }")

  // test "get" and "size"
  println("---")
  list = new LinkedList[Int]
  list.add(1)
  list.add(2)
  list.add(3)
  println(s"size=${list.size}, list(0)=${ list.get(0) }")
  println(s"size=${list.size}, list(1)=${ list.get(1) }")
  println(s"size=${list.size}, list(2)=${ list.get(2) }")
}
