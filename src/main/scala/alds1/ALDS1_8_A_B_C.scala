import scala.collection.mutable.Stack
import scala.io.StdIn.{readInt, readLine}

object ALDS1_8_A_B_C extends App {

  val bst = new Bst()
  val n = readInt
  for (_ <- 0 until n) {
    val arr = readLine.split(" ")
      arr(0) match {
      case "insert" => bst.insert(arr(1).toInt)
      case "delete" => bst.delete(arr(1).toInt)
      case "find" => if (bst.find(arr(1).toInt)) println("yes") else println("no")
      case "print" => bst.printTree()
    }
  }

  class Node(var value: Int) {
    var parent: Node = null
    var left: Node = null
    var right: Node = null
    var visited: Boolean = false
    def hasNoChild = { left == null && right == null }
    def hasTwoChild = {left != null && right != null}
    def hasOneChild = {!hasNoChild && !hasTwoChild}
  }

  class Bst {

    var root: Node = null

    def insert(value: Int): Unit = {
      if (root == null) {
        root = new Node(value)
        return
      }
      var prev: Node = null
      var cur = root
      while (cur != null) {
        prev = cur
        if (cur.value > value) {
          cur = cur.left
          if (cur == null) {
            prev.left = new Node(value)
            prev.left.parent = prev
          }
        } else {
          cur = cur.right
          if (cur == null) {
            prev.right = new Node(value)
            prev.right.parent = prev
          }
        }
      }
    }

    def delete(value: Int): Unit = {
      val node = findNode(value)
      if (node == null) {
        return
      }
      val parent = node.parent
      var child: Node = null
      if (node.hasNoChild) {
        if (parent == null) {
          root = null
        } else {
          updateChild(parent, node, child)
        }
      } else if (node.hasOneChild) {
        child = if (node.left != null) node.left else node.right
        if (parent == null) {
          root = child
        } else {
          child.parent = parent
          updateChild(parent, node, child)
        }
      } else {
        if (parent == null) {
          root = node
        }
        val successor = findSuccessor(node)
        node.value = successor.value
        child = successor.right
        if (child != null) {
          child.parent = successor.parent
        }
        updateChild(successor.parent, successor, child)
      }
    }

    def updateChild(parent: Node, oldChild: Node, newChild: Node): Unit = {
      if (parent.left == oldChild) {
        parent.left = newChild
      } else {
        parent.right = newChild
      }
    }

    def findSuccessor(node: Node): Node = {
      var cur = node.right
      while (cur.left != null) {
        cur = cur.left
      }
      cur
    }

    def find(value: Int): Boolean = {
      val node = findNode(value)
      node != null
    }

    def findNode(value: Int): Node = {
      var cur = root
      while (cur != null) {
        if (cur.value == value) {
          return cur
        } else if (cur.value > value) {
          cur = cur.left
        } else {
          cur = cur.right
        }
      }
      null
    }

    def printTree(): Unit = {
      inOrder()
      preOrder()
    }

    def inOrder(): Unit = {
      val stack = new Stack[Node]
      stack.push(root)
      while (!stack.isEmpty) {
        var node = stack.top
        while (node.left != null && !node.left.visited) {
          stack.push(node.left)
          node = node.left
        }
        node = stack.pop
        if (!node.visited) {
          print(s" ${node.value}")
          node.visited =true
        }
        if (node.right != null && !node.right.visited) {
          stack.push(node.right)
        }
      }
      println()
    }

    def preOrder(): Unit = {
      val stack = new Stack[Node]
      stack.push(root)
      while (!stack.isEmpty) {
        val node = stack.pop
        if (node != null) {
          node.visited = false
          print(s" ${node.value}")
          stack.push(node.right)
          stack.push(node.left)
        }
      }
      println()
    }
  }
}
