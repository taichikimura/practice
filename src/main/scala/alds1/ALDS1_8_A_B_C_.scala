import scala.collection.mutable.Stack
import scala.io.StdIn.{readInt, readLine}

object ALDS1_8_A_B_C_ extends App {

  val bst = new Bst()
  val n = readInt
  val arr = readLine.split(" ")
  arr(0) match {
    case "insert" => bst.insert(arr(1).toInt)
    case "delete" => bst.delete(arr(1).toInt)
    case "find" => if (bst.find(arr(1).toInt)) "yes" else "no"
    case "print" => bst.printTree
  }

  class Node(var value: Int) {
    var parent: Node = null
    var left: Node = null
    var right: Node = null
    var visited = false
    def hasNoChild = {left == null && right == null}
    def hasTwoChild = {left != null && right != null}
    def hasOneChild = {!hasNoChild && !hasTwoChild}
  }

  class Bst {

    var root: Node = null

    def insert(value: Int): Unit = {
      val newNode = new Node(value)
      if (root == null) {
        root = newNode
        return
      }
      var prev = root
      var cur = root
      while (cur != null) {
        if (cur.value < value) {
          cur = cur.left
          if (cur == null) {
            prev.left = newNode
          }
        } else {
          cur = cur.right
          if (cur == null) {
            prev.right = newNode
          }
        }
        prev = cur
      }
    }

    def find(value: Int): Boolean = {
      val node = findNode(value)
      node == null
    }

    def findNode(value: Int): Node = {
      if (root == null) return null
      var cur = root
      while (cur != null) {
        if (cur.value == value) {
          return cur
        }
        if (cur.value < value) {
          cur = cur.left
        } else {
          cur = cur.right
        }
      }
      null
    }

    def delete(value: Int): Unit = {
    }

    def printTree: Unit = {
      inOrder
      preOrder
    }

    def inOrder: Unit = {
      val stack = new Stack[Node]
      stack.push(root)
      while (!stack.isEmpty) {
        var cur = stack.top
        while (cur.left != null && !cur.left.visited) {
          stack.push(cur.left)
          cur = cur.left
        }
        cur = stack.pop
        print(s" ${cur.value}")
        cur.visited = true
        if (cur.right != null && !cur.right.visited) {
          stack.push(cur.right)
        }
      }
      println
    }

    def preOrder: Unit = {
      val stack = new Stack[Node]
      stack.push(root)
      while (!stack.isEmpty) {
        val cur = stack.pop
        print(s" ${cur.value}")
        cur.visited = false
        if (cur.right != null) stack.push(cur.right)
        if (cur.left != null) stack.push(cur.left)
      }
      println
    }
  }
}
