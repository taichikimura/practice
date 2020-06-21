import java.io.ByteArrayInputStream

object AojTest {

  val inputs = Array(
//    "8\ninsert 5\ninsert 1\ninsert 8\ninsert 6\ninsert 20\ninsert 7\ndelete 5\nprint"
//    "7\ninsert 5\ninsert 1\ninsert 8\ninsert 6\ninsert 20\ninsert 7\nprint"
//    "8\ninsert 5\ninsert 1\ninsert 8\ninsert 6\ninsert 20\ninsert 7\ndelete 5\nprint"
//    "7\ninsert 2\ninsert 1\ninsert 3\ninsert 0\ninsert 4\ndelete 2\nprint"
//    "6\ninsert 2\ninsert 1\ninsert 3\ninsert 0\ninsert 4\nprint"
//    "26\ninsert 30\ninsert 17\ninsert 88\ninsert 53\ninsert 5\ninsert 20\ninsert 18\ninsert 28\ninsert 27\ninsert 60\ninsert 2000000000\ninsert 55\ninsert 63\ninsert -1\ninsert 8\nprint\ndelete 53\nprint\ndelete 2000000000\nprint\ndelete 20\nprint\ndelete 5\nprint\ndelete 8\nprint"
//    "43\ninsert 30\ninsert 17\ninsert 88\ninsert 53\ninsert 5\ninsert 20\ninsert 18\ninsert 28\ninsert 27\ninsert 60\nprint\nfind -1\nfind 2\nfind 3\nfind 4\nfind 5\nfind 6\nfind 10\nfind 17\nfind 28\nfind 29\nfind 30\nfind 31\nfind 50\nfind 51\nfind 52\nfind 53\nfind 54\nfind 60\nfind 88\nfind 89\ninsert 2000000000\ninsert 55\ninsert 63\ninsert -1\ninsert 8\nprint\ndelete 53\ndelete 2000000000\ndelete 20\ndelete 5\ndelete 8\nprint"
//    "8\ninsert 8\ninsert 2\ninsert 1\ninsert 3\ninsert 7\ninsert 22\ndelete 2\nprint"
//    "18\ninsert 8\ninsert 2\ninsert 3\ninsert 7\ninsert 22\ninsert 1\nfind 1\nfind 2\nfind 3\nfind 4\nfind 5\nfind 6\nfind 7\nfind 8\nprint\ndelete 3\ndelete 7\nprint"
//    "10\ninsert 30\ninsert 88\ninsert 12\ninsert 1\ninsert 20\nfind 12\ninsert 17\ninsert 25\nfind 16\nprint",
//    "8\ninsert 30\ninsert 88\ninsert 12\ninsert 1\ninsert 20\ninsert 17\ninsert 25\nprint"
//    "4\n1 0 -1\n0 2 -1\n2 3 -1\n3 -1 -1"
//    "9\n0 1 4\n1 2 3\n2 -1 -1\n3 -1 -1\n4 5 8\n5 6 7\n6 -1 -1\n7 -1 -1\n8 -1 -1"
//      "5\n1 2 3 4 5\n3 2 4 1 5",
//      "4\n1 2 3 4\n1 2 3 4",
//      "4\n4 3 2 1\n4 3 2 1"
//    "9\n0 1 4\n1 2 3\n2 -1 -1\n3 -1 -1\n4 5 8\n5 6 7\n6 -1 -1\n7 -1 -1\n8 -1 -1"
//    "9\n0 1 4\n1 2 3\n2 -1 -1\n3 -1 -1\n4 5 8\n5 6 7\n6 -1 -1\n7 -1 -1\n8 -1 -1"
//    "13\n0 3 1 4 10\n1 2 2 3\n2 0\n3 0\n4 3 5 6 7\n5 0\n6 0\n7 2 8 9\n8 0\n9 0\n10 2 11 12\n11 0\n12 0",
//    "1\n0 0",
//    "4\n1 3 3 2 0\n0 0\n3 0\n2 0"
  )

  def main(args: Array[String]): Unit = {
    prepare()
    inputs.foreach { input => {
      ALDS1_8_A_B_C_.main(Array())
    }}
  }

  def prepare(): Unit = {
    val inContent = new ByteArrayInputStream(inputs.mkString("\n").getBytes)
    System.setIn(inContent)
  }
}
