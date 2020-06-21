package main.scala.alds1

import scala.io.StdIn.{readInt, readLine}

object ALDS1_2_B extends App {

  val n = readInt
  val arr = readLine.split(" ").map(_.toInt)

  var swapCount = 0
  for (i <- 0 until n; mini = i; j <- i until n) {
    var mini = i
    for (j <- i until n) {
      if (arr(j) < arr(mini)) {
        mini = j
      }
    }
    if (i != mini) {
      swap(arr, i, mini)
      swapCount += 1
    }
  }

  println(arr.mkString(" "))
  println(swapCount)

  def swap(arr: Array[Int], i: Int, j: Int): Unit = {
    arr(i) = arr(i) ^ arr(j)
    arr(j) = arr(i) ^ arr(j)
    arr(i) = arr(i) ^ arr(j)
  }

}
