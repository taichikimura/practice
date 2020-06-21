import scala.io.StdIn.{readInt, readLine}

object ALDS1_4_C extends App {
  val n = readInt
  val dict = new SimpleDictionary(n)
  for (_ <- 1 to n) {
    val Array(cmd, str) = readLine.split(" ")
    cmd match {
      case "insert" => dict.insert(str)
      case "find" => { println(if (dict.find(str)) "yes" else "no") }
    }
  }

  class SimpleDictionary(inputSize: Int) {

    val size = Math.max(1, inputSize / 100)
    val arr:Array[SimpleLinkedList] = new Array[SimpleLinkedList](size)

    def insert(str: String): Unit = {
      val hashCode = (str.hashCode % size).abs
      var linkedList = arr(hashCode)
      if (linkedList == null) {
        linkedList = new SimpleLinkedList()
      }
      if (!linkedList.exists(str)) {
        linkedList.insert(str)
      }
      arr(hashCode) = linkedList
    }

    def find(str: String): Boolean = {
      val hashCode = (str.hashCode % size).abs
      val linkedList = arr(hashCode)
      if (linkedList == null) {
        return false
      }
      linkedList.exists(str)
    }
  }

  class SimpleLinkedList {

    class Node(v: String) {
      val value: String = v
      var next: Node = null
    }

    var head: Node = null

    def insert(value: String): Unit = {
      val newNode = new Node(value)
      newNode.next = head
      head = newNode
    }

    def exists(value: String): Boolean = {
      var current = head
      while (current != null) {
        if (current.value.equals(value)) {
          return true
        }
        current = current.next
      }
      false
    }

  }
}
