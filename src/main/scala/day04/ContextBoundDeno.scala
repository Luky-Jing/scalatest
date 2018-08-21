package day04

/**
  * Created by lipeijing on 2018/8/21.
  */
class ContextBoundDeno[T: Ordering] {
  def select(first: T, second: T): T = {
    val ord: Ordering[T] = implicitly[Ordering[T]]
    if (ord.gt(first, second)) first else second
  }
}

object ContextBoundDeno {
  def main(args: Array[String]): Unit = {
    import MyPredef.OrderingGirl

    val contextBoundDeno = new ContextBoundDeno[MyGirl]
    val g1 = new MyGirl("data", 22, 2222)
    val g2 = new MyGirl("ddd", 23, 2222)

    val res = contextBoundDeno.select(g1, g2)
    println(res.name)
  }
}