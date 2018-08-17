package day03

object ClassDemo {
  def main(args: Array[String]): Unit = {
    val human = new Human
    println(human.name)
    println(human.distance)
    println(human.climb)
    println(human.fight)
  }
}

/**
  * 特质
  */
trait Flyable {
  //声明一个没有值的字段
  val distance: Int

  //声明没有实现的方法
  def fight: String

  def fly: Unit = {
    println("I can fly")
  }
}

/**
  * 抽象类
  */

abstract class Animal {
  val name: String
  def run(): String

  def climb: String = {
    "I can climb"
  }
}

class Human extends Animal with Flyable {
  override val name: String = "lipeijing"

  // 重写抽象类没有实现的方法
  override def run(): String = {
    "I can run"
  }

  // 重写抽象类方法
  override def climb: String = {
    "override climb"
  }

  override val distance: Int = 1000

  // 实现特质中没有实现的方法
  override def fight: String = "with fengzi"

  override def fly: Unit = println("override fly")
}