import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.{readInt, readLine}

object ALDS1_7_A extends App {

  val n = readInt
  val nodes = Array.fill[Node](n)(new Node)
  for (_ <- 0 until n) {
    val arr = readLine.split(" ").map(_.toInt)
    val id = arr(0)
    nodes(id).id = id
    for (i <- 2 until 2 + arr(1)) {
      val childId = arr(i)
      nodes(id).children += childId
      nodes(childId).parent = id
    }
  }
  val root = nodes.filter(_.parent == -1)(0)
  setDepth(nodes, root.id, 0)
  println(nodes.mkString("\n"))

  def setDepth(nodes: Array[Node], id: Int, depth: Int): Unit = {
    nodes(id).depth = depth
    nodes(id).children.foreach( e => {
      setDepth(nodes, nodes(e).id, depth + 1)
    })
  }

  class Node {
    var id = -1
    var parent = -1
    var children = new ArrayBuffer[Int]()
    var depth = 0
    override def toString: String = {
      val nodeType = {
        if (parent == -1) "root"
        else if (children.length == 0) "leaf"
        else "internal node"
      }
      s"node ${id}: parent = ${parent}, depth = ${depth}, ${nodeType}, [${children.mkString(", ")}]"
    }
  }
}
