package main.scala.alds1

import scala.io.StdIn.{readInt, readLine}

object ALDS1_2_A extends App {

  val n = readInt()
  val arr = readLine().split(" ").map(_.toInt)

  var swapCount = 0
  for (i <- 0 to n - 1; j <- n - 1 to i + 1 by -1) {
    if (arr(j) < arr(j - 1)) {
      swap(arr, j, j - 1)
      swapCount += 1
    }
  }
  println(arr.mkString(" "))
  println(swapCount)

  def swap(arr: Array[Int], i: Int, j: Int) = {
    arr(i) = arr(i) ^ arr(j)
    arr(j) = arr(i) ^ arr(j)
    arr(i) = arr(i) ^ arr(j)
  }

}
