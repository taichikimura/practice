import scala.io.StdIn.{readInt, readLine}

object ITP1_6_C {
  def main(args: Array[String]): Unit = {
    val n = readInt()
    val arr = Array.fill(4, 3, 10)(0)
    for (_ <- 1 to n) {
      val Array(b, f, r, v) = readLine().split(" ").map(_.toInt)
      arr(b-1)(f-1)(r-1) += v
    }
    println(arr.map(_.map(_.map(" "+_).mkString).mkString("\n")).mkString(s"\n${"#" * 20}\n"))
  }
}
