import scala.io.StdIn.{readInt, readLine}

object ALDS1_5_B extends App {

  val n = readInt
  val arr = readLine.split(" ").map(_.toInt)
  val cnt = mergeSort(arr, left=0, right=arr.length - 1, cnt=0)
  println(arr.mkString(" "))
  println(cnt)

  def mergeSort(arr: Array[Int], left: Int, right: Int, cnt: Int): Int = {
    if (left == right) {
      return 0
    }
    var count = 0
    val mid = (left + right) / 2
    count += mergeSort(arr, left, mid, cnt)
    count += mergeSort(arr, mid + 1, right, cnt)
    count += merge(arr, left, mid, right, cnt)
    count
  }

  def merge(arr: Array[Int], left: Int, mid: Int, right: Int, cnt: Int): Int = {

    val len1 = (mid + 1) - left
    val len2 = right - mid
    val L: Array[Int] = new Array[Int](len1 + 1)
    val R: Array[Int] = new Array[Int](len2 + 1)
    for (i <- 0 until len1) L(i) = arr(left + i)
    for (i <- 0 until len2) R(i) = arr((mid + 1) + i)
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
        j += 1
      }
      k += 1
      count += 1
    }
    count
  }
}
