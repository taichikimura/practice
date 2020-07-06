import scala.collection.mutable.Stack
import scala.io.StdIn.{readInt, readLine}

object ALDS1_8_D extends App {

  val treap = new Treap
  val n = readInt
  for (i <- 0 until n) {
    val arr = readLine.split(" ")
    val cmd = arr(0)
    cmd match {
      case "insert" => treap.insert(key=arr(1).toInt, pri=arr(2).toInt)
      case "delete" => treap.delete(key=arr(1).toInt)
      case "find" => println(if (treap.find(key=arr(1).toInt)) "yes" else "no")
      case "print" => treap.printTree
    }
  }

  class Treap {

    class Node(var key: Int, var pri: Int) {
      var parent: Node = null
      var left: Node = null
      var right: Node = null
      var visited = false
    }

    var root: Node = null

    def insert(key: Int, pri: Int): Unit = {
      root = insert(root, key, pri)
    }

    def insert(node: Node, key: Int, pri: Int): Node = {
      var t = node
      if (t == null) {
        return new Node(key, pri)
      }
      if (t.key == key) {
        return t
      }
      if (key < t.key) {
        t.left = insert(t.left, key, pri)
        if (t.pri < t.left.pri) {
          t = rightRotate(t)
        }
      } else {
        t.right = insert(t.right, key, pri)
        if (t.pri < t.right.pri) {
          t = leftRotate(t)
        }
      }
      t
    }

    def rightRotate(t: Node): Node = {
      val s = t.left
      t.left = s.right
      s.right = t
      s
    }

    def leftRotate(t: Node): Node = {
      val s = t.right
      t.right = s.left
      s.left = t
      s
    }

    def delete(key: Int): Unit = {
      root = delete(root, key)
    }

    def delete(node: Node, key: Int): Node = {
      val t = node
      if (t == null) {
        return null
      }
      if (key < t.key) {
        t.left = delete(t.left, key)
      } else if (key > t.key) {
        t.right = delete(t.right, key)
      } else {
        return _delete(t, key)
      }
      t
    }

    def _delete(node: Node, key: Int): Node = {
      var t = node
      if (t.left == null && t.right == null) {
        return null
      } else if (t.left == null) {
        t = leftRotate(t)
      } else if (t.right == null) {
        t = rightRotate(t)
      } else {
        if (t.left.pri > t.right.pri) {
          t = rightRotate(t)
        } else {
          t = leftRotate(t)
        }
      }
      delete(t, key)
    }

    def find(key: Int): Boolean = {
      val node = findNode(root, key)
      node != null
    }

    def findNode(node: Node, key: Int): Node = {
      var t = node
      if (t == null) {
        return null
      }
      if (key == t.key) {
        return t
      }
      if (key < t.key) {
        t = findNode(t.left, key)
      } else {
        t = findNode(t.right, key)
      }
      t
    }

    def printTree: Unit = {
      inOrder
      preOrder
    }

    def inOrder: Unit = {
      val stack = new Stack[Node]
      stack.push(root)
      while (!stack.isEmpty) {
        var t = stack.top
        while (t.left != null && !t.left.visited) {
          stack.push(t.left)
          t = t.left
        }
        t = stack.pop
        print(s" ${t.key}")
        t.visited = true
        if (t.right != null && !t.right.visited) {
          stack.push(t.right)
        }
      }
      println
    }

    def preOrder: Unit = {
      val stack = new Stack[Node]
      stack.push(root)
      while (!stack.isEmpty) {
        val t = stack.pop
        print(s" ${t.key}")
        t.visited = false
        if (t.right != null) stack.push(t.right)
        if (t.left != null) stack.push(t.left)
      }
      println
    }

  }
}