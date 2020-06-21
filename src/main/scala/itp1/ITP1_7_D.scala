package main.scala.itp1

import scala.io.StdIn.readLine

object ITP1_7_D {

  def main(args: Array[String]): Unit = {
    val Array(n, m, l) = readLine().split(" ").map(_.toInt)
    val a = Array.ofDim[Int](n, m)
    val b = Array.ofDim[Int](m, l)
    for (i <- 0 until n) {
      a(i) = readLine().split(" ").map(_.toInt)
    }
    for (i <- 0 until m) {
      b(i) = readLine().split(" ").map(_.toInt)
    }

    val c = Array.ofDim[Long](n, l)
    for (i <- 0 until n; j <- 0 until l; k <- 0 until m) {
      c(i)(j) += a(i)(k) * b(k)(j)
    }
    println(c.map(_.mkString(" ")).mkString("\n"))
  }
}
