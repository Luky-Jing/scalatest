package day04

object ImplicitContext {
  implicit object OderingGirl extends Ordering[Girl] {
    override def compare(x: Girl, y: Girl): Int = if (x.faceValue > y.faceValue) 1 else -1
  }
}

class Girl(val name: String, var faceValue: Int) {
  override def toString: String = s"name: $name, faceValue: $faceValue"
}

class Goddess[T: Ordering](val v1: T, val v2: T) {
  def choose()(implicit ord: Ordering[T]) = if (ord.gt(v1, v2)) v1 else v2
}

object Goddess {
  def main(args: Array[String]): Unit = {
    import ImplicitContext.OderingGirl

    val girl1 = new Girl("lili", 23)
    val girl2 = new Girl("peipei", 24)

//    val goddess = new Goddess(girl1, girl2)
//    val res = goddess.choose()
//    println(res)
  }
}