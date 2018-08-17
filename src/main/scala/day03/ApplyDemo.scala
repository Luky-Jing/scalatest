package day03

/**
  * Created by lipeijing on 2018/8/16.
  * apply方法通常称为注入方法，在伴生对象里做一些初始化操作
  * apply方法的参数不需要和构造器参数列表一致
  * unapply通常称为提取方法，使用unapply方法来提取固定数量对象
  * unapply方法返回一个序列（option），内部产生一个Some对象存放值
  * apply方法会被unapply方法隐式调用
  */
class ApplyDemo(val name: String, var age: Int, var faceValue: Int) {

}

object ApplyDemo {

  // 操作初始化
  def apply(name: String, age: Int, faceValue: Int): ApplyDemo =
    new ApplyDemo(name, age, faceValue)

  // 提取方法
  def unapply(applyDemo: ApplyDemo): Option[(String, Int, Int)] = {
    if (applyDemo == null){
      None
    } else {
      Some(applyDemo.name, applyDemo.age, applyDemo.faceValue)
    }
  }
}

object Test2 {
  def main(args: Array[String]): Unit = {
    val applyDemo = ApplyDemo.apply("lipeijing", 23, 90)
    applyDemo match {
      case ApplyDemo("lipeijing", age, faceValue) => println(s"age:$age")
      case _ => println("No match nothing")
    }
  }
}