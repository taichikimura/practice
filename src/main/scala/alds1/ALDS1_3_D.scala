import java.util.EmptyStackException

import scala.io.StdIn.readLine

object ALDS1_3_D extends App {

  val st1 = new Stack[Int]()
  val st2 = new Stack[(Int, Int)]()
  val arr = readLine.toCharArray

  arr.zipWithIndex.foreach { case (char, pos) => {
    char match {
      case '\\' => {
        st1.push(pos)
      }
      case '/' => {
        processUp(pos, st1, st2)
      }
      case _ => {}
    }
  }
  }

  var total = 0
  var resArr = Array[Int]()
  val itr: Iterator[(Int, Int)] = st2.iterator
  while (itr.hasNext) {
    val area = itr.next()
    resArr = resArr :+ area._2
    total += area._2
  }

  println(total)
  print(st2.count)
  if (st2.count > 0) {
    print(" " + resArr.reverse.mkString(" "))
  }
  println()

  def processUp(cur: Int, st1: Stack[Int], st2: Stack[(Int, Int)]): Unit = {

    if (st1.isEmpty) {
      return
    }

    val lastPos = st1.pop()
    var curArea = cur - lastPos
    if (st2.isEmpty) {
      st2.push(lastPos, curArea)
      return
    }

    var continue = true
    while (continue && !st2.isEmpty()) {
      val lastArea = st2.pop()
      if (lastArea._1 > lastPos) {
        curArea += lastArea._2
      } else {
        st2.push(lastArea)
        continue = false
      }
    }
    st2.push(lastPos, curArea)
  }

  class Node[T](v: T) {
    var value: T = v
    var next: Node[T] = null
    var prev: Node[T] = null
  }

  class Stack[T] extends Iterable[T] {

    var top: Node[T] = null
    var bottom: Node[T] = null
    var count = 0

    def push(value: T): Unit = {
      val newNode = new Node[T](value)
      if (count == 0) {
        bottom = newNode
      } else {
        top.prev = newNode
        newNode.next = top
      }
      top = newNode
      count += 1
    }

    def pop(): T = {
      if (count == 0) {
        throw new EmptyStackException()
      }
      val ret = top.value
      top = top.next
      count -= 1
      ret
    }

    def peek(): T = {
      if (count == 0) {
        throw new EmptyStackException()
      }
      top.value
    }

    override def isEmpty(): Boolean = {
      count == 0
    }

    override def iterator: Iterator[T] = {
      new StackIterator(top)
    }
  }

  class StackIterator[T](top: Node[T]) extends Iterator[T] {

    var current: Node[T] = top

    override def hasNext: Boolean = {
      current != null
    }

    override def next(): T = {
      val value = current.value
      current = current.next
      value
    }
  }

}
