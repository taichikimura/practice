package main.scala.itp1

import scala.io.StdIn.{readInt, readLine}

object ITP1_9_C extends App {
  var Array(p1, p2) = Array(0, 0)
  val m = readInt()
  for (_ <- 1 to m) {
    val Array(c1, c2) = readLine().split(" ")
    if (c1 > c2) p1 += 3
    else if (c2 > c1) p2 += 3
    else { p1 += 1; p2 += 1 }
  }
  println(s"$p1 $p2")
}
