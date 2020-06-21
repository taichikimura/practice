package main.scala.itp1

import scala.io.Source.stdin

object ITP1_8_C {

  def main(args: Array[String]) {
    val alphabets = Array.fill[Int](128)(0)
    stdin.getLines.foreach { _.foreach {
      s => alphabets(s.toLower) += 1
    }}

    for (i <- 'a' to 'z') {
      println(i + " : " + alphabets(i))
    }
  }
}
