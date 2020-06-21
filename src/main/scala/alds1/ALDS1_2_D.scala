package main.scala.alds1

import scala.io.StdIn.readInt

object ALDS1_2_D extends App {

  val n = readInt
  val arr = Array.fill(n)(0)
  for (i <- 0 until n) {
    arr(i) = readInt
  }
  shellSort(arr, n)
  println(arr.mkString("\n"))

  def shellSort(arr: Array[Int], n: Int): Unit = {
    var cnt = 0
    val G = buildGArray(n)
    G.foreach(g => cnt += insertionSort(arr, n, g))
    println(G.length)
    println(G.mkString(" "))
    println(cnt)
  }

  def buildGArray(n: Int): Array[Int] = {
    var v = 1
    var arr = Array[Int](v)
    val increment = (v: Int) => {v * 3 + 1}
    v = increment(v)
    while (v < n) {
      arr = arr :+ v
      v = increment(v)
    }
    arr.reverse
  }

  def insertionSort(arr: Array[Int], n: Int, g: Int): Int = {
    var cnt = 0
    for (i <- g to n - 1) {
      val v = arr(i)
      var j = i - g
      while (j >= 0 && arr(j) > v) {
        arr(j + g) = arr(j)
        j = j - g
        cnt += 1
      }
      arr(j + g) = v
    }
    cnt
  }
}
