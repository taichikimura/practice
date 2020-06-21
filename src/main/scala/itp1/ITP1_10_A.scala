package main.scala.itp1

import scala.io.StdIn.readLine

object ITP1_10_A extends App {
  val Array(x1, y1, x2, y2) = readLine().split(" ").map(_.toDouble)
  val len1 = (x1 - x2)
  val len2 = (y1 - y2)
  println(Math.sqrt(len1 * len1 + len2 * len2))
}
