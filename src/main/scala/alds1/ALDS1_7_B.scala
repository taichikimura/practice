import scala.io.StdIn.{readInt, readLine}

object ALDS1_7_B extends App {
  val n = readInt
  val nodes = Array.fill[Node](n)(new Node)
  for (_ <- 0 until n) {
    val Array(id, left, right) = readLine.split(" ").map(_.toInt)
    nodes(id).id = id
    nodes(id).left = left
    nodes(id).right = right
    if (left != -1) setSibling(nodes, id, left, right)
    if (right != -1) setSibling(nodes, id, right, left)
  }
  nodes.filter(_.parent == -1).foreach(rootNode => {setDepth(nodes, rootNode.id, depth = 0)})
  nodes.filter(_.degree == 0).foreach(leafNode => {setHeight(nodes, leafNode.id, height = 0)})
  println(nodes.mkString("\n"))

  def setSibling(nodes: Array[Node], id: Int, siblingId: Int, otherSiblingId: Int): Unit = {
    nodes(id).degree += 1
    nodes(siblingId).parent = id
    nodes(siblingId).sibling = otherSiblingId
  }

  def setDepth(nodes: Array[Node], id: Int, depth : Int): Unit = {
    nodes(id).depth = depth
    if (nodes(id).left != -1) setDepth(nodes, nodes(id).left, depth + 1)
    if (nodes(id).right != -1) setDepth(nodes, nodes(id).right, depth + 1)
  }

  def setHeight(nodes: Array[Node], id: Int, height : Int): Unit = {
    nodes(id).height = Math.max(nodes(id).height, height)
    if (nodes(id).parent != -1) {
      setHeight(nodes, nodes(id).parent, nodes(id).height + 1)
    }
  }

  class Node {
    var id = -1
    var parent = -1
    var sibling = -1
    var left = -1
    var right = -1
    var degree = 0
    var depth = 0
    var height = 0
    override def toString: String = {
      val nodeType = {
        if (parent == -1) "root"
        else if (degree == 0) "leaf"
        else "internal node"
      }
      s"node ${id}: parent = ${parent}, sibling = ${sibling}, degree = ${degree}, depth = ${depth}, height = ${height}, ${nodeType}"
    }
  }
}
