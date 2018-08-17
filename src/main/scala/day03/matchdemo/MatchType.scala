package day03.matchdemo

import scala.util.Random

object MatchType {
  def main(args: Array[String]): Unit = {
    val arr = Array("abcd", 1, 1.23, true, MatchType)

    val element = arr(Random.nextInt(arr.length))

    println(element)

    element match {
      case str: String => println(s"match String: $str")
      case int: Int => println(s"match Int: $int")
      case double: Double => println(s"match Double: $double")
      case bool: Boolean => println(s"match Boolean: $bool")
      case matchTest: MatchTest => println(s"match MatchType: $matchTest")
      case _: Any => println(s"match Any: no")
    }
  }
}

class MatchTest {

}