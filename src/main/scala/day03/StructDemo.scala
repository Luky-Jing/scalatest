package day03

/**
  * 主构造器的参数列表要放在类名后面，和类名放一起
  * val修饰的构造参数具有不可变性，var修饰的可变性
  * faceValue只能在本类调用，伴生对象无法调用
  * faceValue默认是val
  */

/**
  * Created by lipeijing on 2018/8/15.
  */
class StructDemo(val name: String, val age: Int, faceValue: Int) {

  var gender: String = _

  def getFaceValue(): Int = {
    faceValue // 此时是val修饰
  }

  // 辅助构造器
  def this(name: String, age: Int, faceValue: Int, gender: String) {
    this(name, age, faceValue) // 辅助构造器第一行必须前调用主构造器
    this.gender = gender
  }
}

object StructDemo {
  def main(args: Array[String]): Unit = {
//    val s = new StructDemo("lipeijing", 23, 98)
    val s = new StructDemo("lipeijing", 23, 98, "man")
    println(s.name)
    println(s.age)
//    println(s.faceValue) 无法访问
    print(s.getFaceValue())
    print(s.gender)
  }
}