package day03.matchdemo

import scala.util.Random

object MatchStr {
  def main(args: Array[String]): Unit = {
    val arr = Array("scala", "java", "python")

    val name = arr(Random.nextInt(arr.length))

    println(name)

    name match {
      case "scala" => println("spark")
      case "java" => println("web")
      case "python" => println("devops")
      case _ => println("no have")
    }
  }
}