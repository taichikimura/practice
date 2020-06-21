import scala.io.StdIn.{readInt, readLine}

object ALDS1_4_A extends App {
  val n = readInt
  val numbers = readLine.split(" ").map(_.toInt) :+ 0
  val q = readInt
  var ans = 0
  readLine.split(" ").foreach( key => {
    ans += linerSearch(n, numbers, key.toInt)
  })
  println(ans)

  def linerSearch(n: Int, numbers: Array[Int], key: Int): Int = {
    numbers(n) = key
    var i = 0
    while (numbers(i) != key) {
      i += 1
    }
    if (i == n) 0 else 1
  }
}
