import scala.collection.mutable.Stack
import scala.io.StdIn.{readInt, readLine}

object ALDS1_7_C extends App {

  class Node {
    var id = -1
    var parent = -1
    var left = -1
    var right = -1
  }

  val n = readInt
  val nodes = Array.fill[Node](n)(new Node)
  for (_ <- 0 to n - 1) {
    val Array(id, left, right) = readLine.split(" ").map(_.toInt)
    nodes(id).id = id
    nodes(id).left = left
    nodes(id).right = right
    if (left != -1) nodes(left).parent = id
    if (right != -1) nodes(right).parent = id
  }

  val root = nodes.filter(_.parent == -1)(0)
  preOrder(nodes, root)
  inOrder(nodes, root)
  postOrder(nodes, root)

  def preOrder(nodes: Array[Node], root: Node) = {
    println("Preorder")
    val stack = new Stack[Int]
    stack.push(root.id)
    while (!stack.isEmpty) {
      val id = stack.pop
      if (id != -1) {
        print(s" ${id}")
        stack.push(nodes(id).right)
        stack.push(nodes(id).left)
      }
    }
    println()
  }

  def inOrder(nodes: Array[Node], root: Node) = {
    println("Inorder")
    val visited = Array.fill[Boolean](nodes.length)(false)
    val stack = new Stack[Int]
    stack.push(root.id)
    while (!stack.isEmpty) {
      var id = nodes(stack.top).left
      while (id != -1 && !visited(id)) {
        stack.push(id)
        id = nodes(id).left
      }
      id = stack.pop
      print(s" ${id}")
      visited(id) = true
      id = nodes(id).right
      if (id != -1 && !visited(id)) {
        stack.push(id)
      }
    }
    println()
  }

  def postOrder(nodes: Array[Node], root: Node) = {
    println("Postorder")
    val visited = Array.fill[Boolean](nodes.length)(false)
    val stack = new Stack[Int]
    stack.push(root.id)
    while (!stack.isEmpty) {
      val id = stack.top
      val right = nodes(id).right
      val left = nodes(id).left
      if (right != -1 && !visited(right)) {
        stack.push(right)
      }
      if (left != -1 && !visited(left)) {
        stack.push(left)
      }
      if (isLeaf(left, right) || childrenVisited(visited, left, right)) {
        print(s" ${id}")
        visited(id) = true
        stack.pop
      }
    }
    println()
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
