package day03.matchdemo

object MatchList {
  def main(args: Array[String]): Unit = {
    val arr = Array(3, 2, 1)

    arr match {
      case Array(3, a, b) => println(s"case: $a, $b")
      case Array(_, x, y) => println(s"case: $x")
      case _ => println("Match no")
    }

    val tup = (2, 3, 4)

    tup match {
      case (2, a, b) => println(s"case: $a, $b")
      case (_, x, y) => println(s"case: $x")
      case _ => println("Match no")
    }

    val list1 = List(0, 1, 2, 3)
    list1 match {
      case 0 :: Nil => println("case: 0")
      case a :: b :: c :: d :: Nil => println(s"case: $a, $b, $c")
      case 0 :: a => println(s"case3: $a")
      case _ => println("Match no")
    }
  }
}