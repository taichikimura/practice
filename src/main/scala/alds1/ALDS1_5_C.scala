import scala.io.StdIn.readInt

object ALDS1_5_C extends App {

  val n = readInt
  val p1 = new Point(0d, 0d)
  val p2 = new Point(100d, 0d)
  p1.printPoint
  kochCurve(n, 0, p1, p2)
  p2.printPoint

  class Point(val x: Double, val y: Double) {
    def printPoint(): Unit = {
      println(f"${x} ${y}")
    }
  }

  def kochCurve(n: Int, i: Int, p1: Point, p2: Point): Unit = {
    if (n == i) {
      return
    }
    val s = getPointOnLine(p1, p2, portion = 1.0 / 3.0)
    val t = getPointOnLine(p1, p2, portion = 2.0 / 3.0)
    val u = getCornerPoint(s, t)
    kochCurve(n, i + 1, p1, s)
    s.printPoint
    kochCurve(n, i + 1, s, u)
    u.printPoint
    kochCurve(n, i + 1, u, t)
    t.printPoint
    kochCurve(n, i + 1, t, p2)
  }

  def getCornerPoint(s: Point, t: Point): Point = {
    var edgePoint: Point = null
    val len = getLen(s, t)
    if (s.y == t.y) {
      val base = len * Math.cos(Math.toRadians(60))
      val height = len * Math.sin(Math.toRadians(60))
      if (s.x < t.x) {
        edgePoint = new Point(s.x + base, s.y + height)
      } else {
        edgePoint = new Point(s.x - base, s.y - height)
      }
    } else {
      if (isLeftBottomToRightTop(s, t)) {
        edgePoint = new Point(t.x - len, t.y)
      } else if (isLeftTopToRightBottom(s, t)) {
        edgePoint = new Point(s.x + len, s.y)
      } else if (isRightTopToLeftBottom(s, t)) {
        edgePoint = new Point(t.x + len, t.y)
      } else {
        edgePoint = new Point(s.x - len, s.y)
      }
    }
    edgePoint
  }

  def isLeftTopToRightBottom(p1: Point, p2: Point): Boolean = {
    p1.x < p2.x && p1.y > p2.y
  }

  def isLeftBottomToRightTop(p1: Point, p2: Point): Boolean = {
    p1.x < p2.x && p1.y < p2.y
  }

  def isRightTopToLeftBottom(p1: Point, p2: Point): Boolean = {
    p1.x > p2.x && p1.y > p2.y
  }

  def getLen(p1: Point, p2: Point, portion: Double = 1d): Double = {
    val base = p1.x - p2.x
    val height = p1.y - p2.y
    val len = Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2))
    len * portion
  }

  def getPointOnLine(p1: Point, p2: Point, portion: Double): Point = {
    val xDelta = (p2.x - p1.x) * portion
    val yDelta = (p2.y - p1.y) * portion
    val x = p1.x + xDelta
    val y = p1.y + yDelta
    new Point(x, y)
  }

}
