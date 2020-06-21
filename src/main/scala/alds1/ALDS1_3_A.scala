import scala.io.StdIn.readLine

object ALDS1_3_A extends App {

  val arr = readLine.split(" ")
  val stack = new Stack[Int]

  arr foreach {
    case "+" => { stack.push(stack.pop + stack.pop) }
    case "-" => { stack.push(- stack.pop + stack.pop) }
    case "*" => { stack.push(stack.pop * stack.pop) }
    case num => { stack.push(num.toInt) }
  }
  println(stack.pop())

  class Stack[T] {

    class Node[T](v: T) {
      val value: T = v
      var next: Node[T] = null
    }

    var top: Node[T] = null

    def push(value: T): Unit = {
      val newNode = new Node[T](value)
      if (top == null) {
        top = newNode
      } else {
        newNode.next = top
        top = newNode
      }
    }

    def pop(): T = {
      val returnNode: Node[T] = top
      if (returnNode != null) {
        top = returnNode.next
      }
      returnNode.value
    }

  }
}
