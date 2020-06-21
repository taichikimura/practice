package main.scala.itp1

import scala.io.Source.stdin

object ITP1_8_B {
  def main(args: Array[String]) {
    stdin.getLines.takeWhile(_ != "0").foreach {
      line => {
        val sum = line.map(_.asDigit).foldLeft(0)(_ + _)
        println(sum)
      }
    }
  }
}
