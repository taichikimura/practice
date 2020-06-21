package main.scala.itp1

import scala.io.StdIn.{readInt, readLine}

object ITP1_9_B extends App {
  var continue = true
  while (continue) {
    var cards = readLine()
    if (cards == "-") {
      continue = false
    } else {
      val m = readInt()
      for (_ <- 1 to m) {
        val (first, second) = cards.splitAt(readInt())
        cards = second + first
      }
      println(cards)
    }
  }
}
