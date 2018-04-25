import scala.annotation.tailrec

object Main {
  def main(args: Array[String]): Unit = {
    println("test")

    val stack = new Stack[Int]
    stack push 1
    println(stack.top)
    println(stack.top)

    stack.pop
    
    stack push 1
    stack push 2
    stack push 3

    println(s"stack size: ${stack.size}\n")

    stack.foreach(println)
  }

  class Stack[T] {
    var root: Node = _
    
    class Node(val value: T, val ref: Node)

    def push(value: T) = {
      if (root == null) root = new Node(value, null)
      else              root = new Node(value, root)
    }

    def top: T =
      if (root == null) throw new Exception("stack is empty")
      else              root.value

    def pop: T = root == null match {
      case true  => throw new Exception("stack is empty")
      case false =>
        val popped = root.value
        root = root.ref
        popped
    }

    def foreach(func: T => Unit): Unit = {
      var ref = root
      while (ref != null) {
        func(ref.value)
        ref = ref.ref
      }
    }

    def size: Int = {
      @tailrec def size(ref: Node, count: Int): Int =
        if (ref == null) count else size(ref.ref, count + 1)
      size(root, 0)
    }

    def size2: Int = {
      var count = 0
      var ref = root
      while (ref != null) {
        ref = ref.ref
        count += 1
      }
      count
    }
  }
}
