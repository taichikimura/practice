import scala.io.StdIn.{readInt, readLine}

object ALDS1_5_A extends App {

  val n = readInt
  val arr = readLine.split(" ").map(_.toInt)
  val q = readInt
  readLine.split(" ").foreach( query => {
    if (solve(arr, 0, query.toInt)) println("yes") else println("no")
  })

  def solve(arr: Array[Int], p: Int, t: Int): Boolean = {
    if (t == 0) return true
    if (p == arr.length) return false
    solve(arr, p + 1, t - arr(p)) || solve(arr, p + 1, t)
  }
}
