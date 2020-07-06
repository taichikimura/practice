import scala.collection.mutable.Stack
import scala.io.StdIn.{readInt, readLine}

object ALDS1_8_A_B_C extends App {

  val bst = new Bst()
  val n = readInt
  for (_ <- 0 until n) {
    val arr = readLine.split(" ")
    val cmd = arr(0)
    var value = 0
    if (arr.length > 1) {
      value = arr(1).toInt
    }
    cmd match {
      case "insert" => bst.insert(value)
      case "delete" => bst.delete(value)
      case "find" => println(if (bst.find(value)) "yes" else "no")
      case "print" => bst.printTree
    }
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
      var cur = root
      var prev = cur
      while (cur != null) {
        if (cur.value > value) {
          cur = cur.left
          if (cur == null) {
            prev.left = newNode
            newNode.parent = prev
          }
        } else {
          cur = cur.right
          if (cur == null) {
            prev.right = newNode
            newNode.parent = prev
          }
        }
        prev = cur
      }
    }

    def find(value: Int): Boolean = {
      val node = findNode(value)
      node != null
    }

    def findNode(value: Int): Node = {
      if (root == null) return null
      var cur = root
      while (cur != null) {
        if (cur.value == value) {
          return cur
        }
        if (cur.value > value) {
          cur = cur.left
        } else {
          cur = cur.right
        }
      }
      null
    }

    def delete(value: Int): Unit = {
      val node = findNode(value)
      if (node == null) return

      val parent = node.parent
      var child: Node = null
      if (node.hasNoChild) {
        if (parent == null) {
          root = null
        } else {
          removeNode(parent, node, child)
        }
      } else if (node.hasOneChild) {
        if (node.left != null) {
          child = node.left
        } else {
          child = node.right
        }
        if (parent == null) {
          root = child
        } else {
          removeNode(parent, node, child)
        }
      } else {
        val successor = findSuccessor(node)
        node.value = successor.value
        if (successor.hasOneChild) {
          child = successor.right
        }
        removeNode(successor.parent, successor, child)
      }
    }

    def removeNode(parent: Node, node: Node, child: Node): Unit = {
      if (parent.left == node) {
        parent.left = child
      } else {
        parent.right = child
      }
      if (child != null) {
        child.parent = parent
      }
    }

    def findSuccessor(node: Node): Node = {
      var cur = node.right
      while (cur.left != null) {
        cur = cur.left
      }
      cur
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
