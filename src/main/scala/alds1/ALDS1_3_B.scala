import scala.io.StdIn.readLine

object ALDS1_3_B extends App {

  val Array(n, q) = readLine.split(" ").map(_.toInt)
  val queue = new Queue[Process]
  for (i <- 1 to n) {
    val Array(name, time) = readLine.split(" ")
    queue.enqueue(new Process(name, time.toInt))
  }

  var time = 0
  while (!queue.empty) {
    val currentProcess = queue.dequeue
    time += currentProcess.process(q)
    if (!currentProcess.completed) {
      queue.enqueue(currentProcess)
    } else {
      println(s"${currentProcess.name} $time")
    }
  }

  class Process(n: String, t: Int) {

    val name = n
    var time = t

    def process(q: Int): Int = {
      val currentTime = Math.min(time, q)
      time -= currentTime
      currentTime
    }

    def completed(): Boolean = {
      time == 0
    }
  }

  class Queue[T] {

    class Node[T](v: T) {
      var value: T = v
      var prev: Node[T] = null
      var next: Node[T] = null
    }

    var size = 0
    var head: Node[T] = null
    var tail: Node[T] = null

    def enqueue(value: T): Unit = {
      val newNode = new Node[T](value)
      if (head == null) {
        head = newNode
      } else {
        tail.prev = newNode
        newNode.next = tail
      }
      tail = newNode
      size += 1
    }

    def dequeue: T = {
      val returnNode: Node[T] = head
      head = returnNode.prev
      size -= 1
      returnNode.value
    }

    def empty: Boolean = {
      size == 0
    }
  }

}
