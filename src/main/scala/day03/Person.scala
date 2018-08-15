package day03

/**
  * Created by lipeijing on 2018/8/15.
  * 声明类是不需要加public关键字，默认是public
  * 一个类文件可以声明多个类
  */
class Person {

  // val变量只读，只有get
  // var可变有set和get方法
  val id: String ="100"
  var name: String = _

  // 用private修饰的属性，只能本类和半生对象访问
  private var age: Int = _

  // 用private[this]该属性属于对象私有变量，只有本类可以访问，伴生对象无法访问
  private[this] val gender = "man"
}

// 伴生类
object Person {
  def main(args: Array[String]): Unit = {
    val p = new Person()
    println(p.id)
    p.name = "lipeijing"
    p.age = 23

    println(p.name)
    println(p.age)

//    println(p.gender)
  }
}

object Test {
  def main(args: Array[String]): Unit = {
    val p = new Person()
//    println(p.age) 无法访问
  }
}