package main.scala.alds1

import scala.io.StdIn.readLine

object ALDS1_1_B extends App {
  val Array(a, b) = readLine().split(" ").map(_.toInt)
  println(gcd(a, b))

  def gcd(x: Int, y: Int): Int = {
    if (y == 0) return x
    gcd(y, x%y)
  }
}
