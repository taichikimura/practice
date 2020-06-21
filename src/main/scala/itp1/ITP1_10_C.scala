package main.scala.itp1

import scala.io.StdIn.readLine

object ITP1_10_C extends App {
  var continue = true
  while (continue) {
    val input = readLine()
    if ("0".equals(input)) {
      continue = false
    } else {
      val values = readLine().split(" ").map(_.toInt)
      val avg: Double = values.map(_.toDouble).sum / values.length
      val variance: Double = values.map(e => (e - avg) * (e - avg)).sum / values.length
      println(Math.sqrt(variance))
    }
  }
}
