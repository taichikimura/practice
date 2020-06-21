package main.scala.alds1

import scala.io.StdIn.{readInt, readLine}

object ALDS1_1_A extends App {

  val n = readInt()
  val arr = readLine().split(" ").map(_.toInt)

  for (i <- 1 to n -1) {
    println(arr.mkString(" "))
    val key = arr(i)
    var j = i - 1
    while (j >= 0 && key < arr(j)) {
      arr(j + 1) = arr(j)
      j -= 1
    }
    arr(j + 1) = key
  }

  println(arr.mkString(" "))
}
