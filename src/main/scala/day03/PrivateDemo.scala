package day03

/**
  * Created by lipeijing on 2018/8/16.
  */

// 类前加private指包访问权限，只有day03有访问权限
private [day03] class PrivateDemo(val gender: Int, val faceValue: Int) {
  private val name = "lipeijing"

  // 只能本类范文
  private [this] var age = 24

  private def sayHello(): Unit = {
    println(s"age: $age")
  }
}

object PrivateDemo {
  def main(args: Array[String]): Unit = {
    val privateDemo = new PrivateDemo(0, 90)

    privateDemo.sayHello()
  }
}

object Test3 {
  def main(args: Array[String]): Unit = {
    val privateDemo = new PrivateDemo(0, 90)

//    privateDemo.sayHello()
  }
}