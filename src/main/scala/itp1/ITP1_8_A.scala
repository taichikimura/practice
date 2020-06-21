package main.scala.itp1

import scala.io.StdIn.readLine

object ITP1_8_A {
  def main(args: Array[String]) {
    val input = readLine()
    val ans = input.map(s => if (s.isLower) s.toUpper else s.toLower)
    println(ans)
  }
}
