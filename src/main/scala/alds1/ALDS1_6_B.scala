import scala.io.StdIn.{readInt, readLine}

object ALDS1_6_B extends App {
  val n = readInt
  val A = readLine.split(" ").map(_.toInt)
  val p = partition(A, 0, n - 1)
  println(A.zipWithIndex.map{ case(e, i) => { if (i == p) s"[$e]" else e }}.mkString(" "))

  def partition(A: Array[Int], p: Int, r: Int): Int = {
    val x = A(r)
    var i = p - 1
    for (j <- p to r - 1) {
      if (A(j) <= x) {
        i += 1
        swap(A, i, j)
      }
    }
    swap(A, i + 1, r)
    i + 1
  }

  def swap(A: Array[Int], i: Int, j: Int): Unit = {
    if (i == j) {
      return
    }
    A(i) = A(i) ^ A(j)
    A(j) = A(i) ^ A(j)
    A(i) = A(i) ^ A(j)
  }
}
