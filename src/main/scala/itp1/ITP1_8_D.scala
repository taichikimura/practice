package main.scala.itp1

import scala.io.StdIn.readLine

object ITP1_8_D extends App {
  val s = readLine()
  val p = readLine()
  if ((s + s).contains(p)) println("Yes") else println("No")
}
