import scala.io.StdIn.{readInt, readLine}

object ALDS1_7_D_ extends App {

  val n = readInt
  val pre = readLine.split(" ").map(_.toInt)
  val in = readLine.split(" ").map(_.toInt)
  var nodes = Array.fill[Node](n)(new Node)
  for (i <- 0 until n) {
    nodes(i).id = pre(i)
    nodes(i).prePos = i
    in.zipWithIndex.foreach{ case(v, j) => {
      if (nodes(i).id == v) nodes(i).inPos = j
    }}
  }
  for (i <- 1 until n) {
    constractTree(nodes, nodes(0), i)
  }

  var index = 0
  val ans = Array.fill[Int](n)(0)
  postOrderWalk(nodes, nodes(0).prePos)
  println(ans.mkString(" "))

  def constractTree(nodes: Array[Node], parent: Node, index: Int): Unit = {
    val current = nodes(index)
    if (parent.inPos > current.inPos) {
      if (parent.left == -1) {
        parent.left = current.prePos
      } else {
        constractTree(nodes, nodes(parent.left), index)
      }
    } else {
      if (parent.right == -1) {
        parent.right = current.prePos
      } else {
        constractTree(nodes, nodes(parent.right), index)
      }
    }
  }

  def postOrderWalk(nodes: Array[Node], pos: Int): Unit = {
    val node = nodes(pos)
    if (node.left != -1) postOrderWalk(nodes, node.left)
    if (node.right != -1) postOrderWalk(nodes, node.right)
    ans(index) = node.id
    index += 1
  }

  class Node {
    var id = -1
    var left = -1
    var right = -1
    var prePos = -1
    var inPos = -1
  }
}
