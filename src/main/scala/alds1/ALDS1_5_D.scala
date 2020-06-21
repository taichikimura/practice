import scala.io.StdIn.{readInt, readLine}

object ALDS1_5_D extends App {

  val n = readInt
  val arr = readLine.split(" ").map(_.toInt)
  println(findNoOfInversion(arr))

  def findNoOfInversion(arr: Array[Int]): Long = {
    mergeSort(arr, 0, arr.length - 1, 0)
  }

  def mergeSort(arr: Array[Int], left: Int, right: Int, cnt: Long): Long = {
    if (left == right) {
      return 0
    }
    val mid = (left + right) / 2
    var count = cnt
    count += mergeSort(arr, left, mid, cnt)
    count += mergeSort(arr, mid + 1, right, cnt)
    count += merge(arr, left, mid, right, cnt)
    count
  }

  def merge(arr: Array[Int], left: Int, mid: Int, right: Int, cnt: Long): Long = {
    val len1 = mid + 1 - left
    val len2 = right - mid
    val L: Array[Int] = Array.fill[Int](len1 + 1)(0)
    val R: Array[Int] = Array.fill[Int](len2 + 1)(0)
    for (i <- 0 until len1) L(i) = arr(left + i)
    for (i <- 0 until len2) R(i) = arr(mid + 1 + i)
    L(len1) = Integer.MAX_VALUE
    R(len2) = Integer.MAX_VALUE
    var count = cnt
    var i = 0
    var j = 0
    var k = left
    while (k <= right) {
      if (L(i) < R(j)) {
        arr(k) = L(i)
        i += 1
      } else {
        arr(k) = R(j)
        count += (j + mid + 1) - k
        j += 1
      }
      k += 1
    }
    count
  }
}
