package main.scala.alds1

import scala.io.StdIn.readInt

object ALDS1_1_D extends App {
  var maxProfit = Integer.MIN_VALUE
  val n = readInt()
  var minValue = readInt()
  for (_ <- 2 to n) {
    val current = readInt()
    maxProfit = Math.max(maxProfit, current - minValue)
    minValue = Math.min(minValue, current)
  }
  println(maxProfit)
}

