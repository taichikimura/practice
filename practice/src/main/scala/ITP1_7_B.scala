
import scala.io.StdIn.readLine

object ITP1_7_B {

  def main(args: Array[String]): Unit = {
    var continue = true
    while (continue) {
      val Array(n, x) = readLine().split(" ").map(_.toInt)
      if (n == 0 && x == 0) {
        continue = false
      } else {
        println(countNoOfWays(n, x))
      }
    }
  }

  def countNoOfWays(n: Int, x: Int): Int = {
    var ans = 0
    for (i <- 1 to n; j <- i+1 to n; k <- j+1 to n) {
      if (i + j + k == x) {
        ans += 1
      }
    }
    ans
  }
}
