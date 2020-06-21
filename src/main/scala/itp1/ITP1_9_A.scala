package main.scala.itp1

import scala.io.StdIn.readLine

object ITP1_9_A extends App {
  val word = readLine()
  var count = 0
  var continue = true
  while (continue) {
    val line = readLine()
    if (line == "END_OF_TEXT") continue = false
    else line.split(" ").foreach(
      eachWord => if (eachWord.equalsIgnoreCase(word)) count += 1
    )
  }
  println(count)
}
