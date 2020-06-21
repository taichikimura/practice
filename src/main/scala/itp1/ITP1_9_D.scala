package main.scala.itp1

import scala.io.StdIn.{readInt, readLine}

object ITP1_9_D extends App {
  var str = readLine()
  val m = readInt()
  for (_ <- 1 to m) {
    val line = readLine().split(" ")
    val cmd = line(0)
    val start = line(1).toInt
    val end = line(2).toInt + 1
    val Array(p1, p2, p3) = splitStr(str, start, end)
    cmd match {
      case "replace" => str = s"$p1${line(3)}$p3"
      case "reverse" => str = s"$p1${p2.reverse}$p3"
      case "print" => println(p2)
    }
  }

  def splitStr(str: String, start: Int, end: Int): Array[String] = {
    val arr = Array[String]("", "", str.substring(end))
    if (start == 0) {
      arr(1) = str.substring(0, end)
    } else {
      arr(0) = str.substring(0, start)
      arr(1) = str.substring(start, end)
    }
    arr
  }
}
