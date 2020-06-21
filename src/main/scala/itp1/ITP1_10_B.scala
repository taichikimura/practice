package main.scala.itp1

import scala.io.StdIn.readLine

object ITP1_10_B extends App {
  val Array(a, b, c) = readLine().split(" ").map(_.toInt)
  val radian = Math.toRadians(c)
  val area = a * b * Math.sin(radian) * 0.5
  val height = 2 * area / a
//  val otherLen = Math.sqrt((a * a) + (b * b) - (2 * a * b * Math.cos(radian)))
  val bottomLen = c match {
    case x if c < 90 => a - Math.sqrt((b * b) - (height * height))
    case _ => a + Math.sqrt((b * b) - (height * height))
  }
  var otherLen = Math.sqrt((bottomLen * bottomLen) + (height * height))
  val circumference = otherLen + a + b;

  println(area)
  println(circumference)
  println(height)
}
