import scala.io.StdIn.{readInt, readLine}

object ALDS1_3_C extends App {
  val n = readInt
  val dllist = new DoublyLinkedList()
  for (i <- 1 to n) {
    val cmd = readLine().split(" ")
    cmd(0) match {
      case "insert" => dllist.insert(cmd(1).toInt)
      case "delete" => dllist.delete(cmd(1).toInt)
      case "deleteFirst" => dllist.deleteFirst
      case "deleteLast" => dllist.deleteLast
    }
  }
  dllist.printStr()

  class DoublyLinkedList {

    class Node(v: Int) {
      val value: Int = v
      var prev: Node = null
      var next: Node = null
    }

    var head: Node = null
    var tail: Node = null

    def insert(x: Int): Unit = {
      val newNode = new Node(x)
      if (head == null) {
        tail = newNode
      } else {
        head.prev = newNode
      }
      newNode.next = head
      head = newNode
    }

    def search(x: Int): (Node, Node) = {
      var current = head
      var prev: Node = null
      while (current != null) {
        if (current.value == x) {
          return (prev, current)
        }
        prev = current
        current = current.next
      }
      (null, null)
    }

    def delete(x: Int): Unit = {
      val (prev, found) = search(x)
      if (found == head) {
        deleteFirst
      } else if (found == tail) {
        deleteLast
      } else if (found != null) {
        prev.next = found.next
        if (found.next != null) {
          found.next.prev = prev
        }
      }
    }

    def deleteLast: Unit = {
      if (head == tail) {
        head = null
        tail = null
      } else {
        tail.prev.next = null
        tail = tail.prev
      }
    }

    def deleteFirst: Unit = {
      if (head == tail) {
        head = null
        tail = null
      } else {
        head.next.prev = null
        head = head.next
      }
    }

    def printStr(): Unit = {
      var current = head
      val sb = new StringBuilder().append(current.value)
      current = current.next
      while (current != null) {
        sb.append(" ").append(current.value)
        current = current.next
      }
      println(sb)
    }
  }

}
