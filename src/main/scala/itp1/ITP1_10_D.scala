package main.scala.itp1

import scala.io.StdIn.{readInt, readLine}

object ITP1_10_D extends App {
  val n = readInt()
  val x = readLine().split(" ").map(_.toInt)
  val y = readLine().split(" ").map(_.toInt)

  println(calcDistance(x, y, 1))
  println(calcDistance(x, y, 2))
  println(calcDistance(x, y, 3))
  println(calcDistance(x, y, 0))

  def calcDistance(x: Array[Int], y: Array[Int], p: Int): Double = {
    p match {
      case p if p > 0 => Math.pow((x zip y).map { case(x, y) => Math.pow((x - y).abs, p) }.sum, 1d/p)
      case _ => (x zip y).map { case (x, y) => (x - y).abs }.max
    }
  }
}
