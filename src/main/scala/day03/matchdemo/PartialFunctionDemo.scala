package day03.matchdemo

/**
  * 偏函数，常用作输入模匹配
  * PartialFunction[A, B]
  * A是参数类型
  * B是返回值类型
  */

object PartialFunctionDemo {

  // String参数类型，返回值类型
  def m1: PartialFunction[String, Int] = {
    case "one" => {
      println("case 1")
      1
    }
    case "two" => {
      println("case 2")
      2
    }
  }

  def m2(num: String): Int = num match {
    case "one" => 1
    case "two" => 2
  }

  def main(args: Array[String]): Unit = {
    println(m1("one"))
    println(m2("two"))
  }
}