package day04

object Context {
  implicit val a = "java"
}

object CurryingDemo {
  def m1(str: String)(implicit name: String = "Scala") = {
    str + name
  }

  def main(args: Array[String]): Unit = {
    val func = m1("Hi~") _
    import Context.a
    println(m1("Hi~"))
  }
}