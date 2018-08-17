package day03

/**
  * Created by lipeijing on 2018/8/16.
  * 与类名相同并且使用object修饰的对象叫做伴生对象
  * 类和其伴生对象之间可以相互访问私有的方法和属性
  */
class Dog {
  private var name = "二哈"

  def printName(): Unit = {
    // 在Dog类中，访问半生对象的私有属性
    println(Dog.CONSTANT + name)
  }
}

/**
  * 伴生对象
  */
object Dog {
  private val CONSTANT = "汪汪汪:"

  def main(args: Array[String]): Unit = {
    val p = new Dog
    p.printName()
  }
}