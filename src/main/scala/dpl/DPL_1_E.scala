import scala.io.StdIn.readLine

object DPL_1_E extends App {

  val str1 = readLine()
  val str2 = readLine()
  println(levenshteinDistance(str1, str2))

  def levenshteinDistance(str1: String, str2: String): Int = {
    val n = str1.length
    val m = str2.length
    val dp = Array.ofDim[Int](m + 1, n + 1)
    for (i <- 0 to m; j <- 0 to n) {
      var cost: Int = 0
      if (i == 0 && j == 0) cost = 0
      else if (i == 0) cost = j
      else if (j == 0) cost = i
      else {
        var substitutionCost = 0
        if (str2.charAt(i-1) != str1.charAt(j-1)) {
          substitutionCost = 1
        }
        substitutionCost = dp(i-1)(j-1) + substitutionCost
        val insertion_cost = dp(i)(j-1) + 1
        val deletion_cost = dp(i-1)(j) + 1
        cost = Math.min(substitutionCost, Math.min(insertion_cost, deletion_cost))
      }
      dp(i)(j) = cost
    }
    dp(m)(n)
  }
}
