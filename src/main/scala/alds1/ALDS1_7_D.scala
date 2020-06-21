import scala.collection.mutable.Stack
import scala.io.StdIn.{readInt, readLine}

object ALDS1_7_D extends App {

  class Node {
    var id = -1
    var left = -1
    var right = -1
    var preOrderPos = -1
    var inOrderPos = -1
  }

  val n = readInt
  val nodes = Array.fill[Node](n)(new Node)
  val pre = readLine.split(" ").map(_.toInt)
  val in = readLine.split(" ").map(_.toInt)
  for (i <- 0 to n - 1) {
    nodes(i).id = pre(i)
    nodes(i).preOrderPos = i
    for (j <- 0 to n - 1) {
      if (nodes(i).id == in(j)) {
        nodes(i).inOrderPos = j
      }
    }
  }

  val root = nodes(0)
  for (i <- 1 to n - 1) {
    addChild(nodes, 0, i)
  }

  postOrderTraversal(nodes)

  def addChild(nodes: Array[Node], parentIdx: Int, idx: Int): Unit = {
    val parent = nodes(parentIdx)
    val left = nodes(parentIdx).left
    val right = nodes(parentIdx).right
    val node = nodes(idx)
    if (parent.inOrderPos > node.inOrderPos) {
      if (left == -1) parent.left = idx
      else addChild(nodes, left, idx)
    } else {
      if (right == -1) parent.right = idx
      else addChild(nodes, right, idx)
    }
  }

  def postOrderTraversal(nodes: Array[Node]): Unit = {
    val visited = Array.fill[Boolean](nodes.length)(false)
    val postOrder = Array.fill[Int](nodes.length)(-1)
    var cnt = 0
    val stack = new Stack[Int]
    stack.push(0)
    while(!stack.isEmpty) {
      val idx = stack.top
      val left = nodes(idx).left
      val right = nodes(idx).right
      if (right != -1 && !visited(right)) {
        stack.push(right)
      }
      if (left != -1 && !visited(left)) {
        stack.push(left)
      }
      if (isLeaf(left, right) || childrenVisited(visited, left, right)) {
        postOrder(cnt) = nodes(idx).id
        cnt += 1
        visited(idx) = true
        stack.pop
      }
    }
    println(postOrder.mkString(" "))
  }

  def isLeaf(left: Int, right: Int): Boolean = {
    left == -1 && right == -1
  }

  def childrenVisited(visited: Array[Boolean], left: Int, right: Int): Boolean = {
    val leftVisited = if (left == -1) true else visited(left)
    val rightVisited = if (right == -1) true else visited(right)
    leftVisited && rightVisited
  }
}
