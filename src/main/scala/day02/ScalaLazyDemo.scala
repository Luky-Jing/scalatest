package day02

/**
  * lazy会实现延迟加载
  * 只能是不可变变量，调用变量才会执行
  */
class ScalaLazyDemo {

}

object ScalaLazyDemo1 {
  def init(): Unit = {
    println("call init")
  }
  def main(args: Array[String]): Unit = {
    val property = init() //没有用lazy关键字修饰
    println("after init()")
    println(property)
  }
}

object ScalaLazyDemo2 {
  def init(): Unit = {
    println("call init")
  }
  def main(args: Array[String]): Unit = {
    lazy val property = init() //用lazy关键字修饰
    println("after init()")
    println(property)
  }
}
