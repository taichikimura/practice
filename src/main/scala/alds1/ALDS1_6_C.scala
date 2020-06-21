import scala.io.StdIn.{readInt, readLine}

object ALDS1_6_C extends App {

  class Card(val input: String, val inputOrder: Int) {
    val mark = input.split(" ")(0)
    val rank = input.split(" ")(1).toInt
  }

  val n = readInt
  val arr = Array.fill[Card](n)(null)
  for (i <- 0 until n) {
    arr(i) = new Card(readLine, i)
  }
  quickSort(arr)
  if (isStable(arr)) {
    println("Stable")
  } else {
    println("Not stable")
  }
  println(arr.map(e => s"${e.mark} ${e.rank}").mkString("\n"))

  def isStable(sortedArr: Array[Card]): Boolean = {
    sortedArr.zipWithIndex.foreach { case(e, i) => {
      if (i < sortedArr.length - 1) {
        val next = sortedArr(i + 1)
        if (e.rank == next.rank && e.inputOrder > next.inputOrder) {
          return false
        }
      }
    }}
    true
  }

  def quickSort(arr: Array[Card]): Unit = {
    quickSort(arr, 0, arr.length - 1)
  }

  def quickSort(arr: Array[Card], p: Int, r: Int): Unit = {
    if (p < r) {
      val q = partition(arr, p, r)
      quickSort(arr, p, q - 1)
      quickSort(arr, q + 1, r)
    }
  }

  def partition(arr: Array[Card], p: Int, r: Int): Int = {
    var i = p - 1
    for (j <- p to r - 1) {
      if (arr(j).rank <= arr(r).rank) {
        i = i + 1
        exchange(arr, i, j)
      }
    }
    exchange(arr, i + 1, r)
    i + 1
  }

  def exchange(arr: Array[Card], i: Int, j: Int): Unit = {
    if (i != j) {
      val tmp = arr(i)
      arr(i) = arr(j)
      arr(j) = tmp
    }
  }

}
