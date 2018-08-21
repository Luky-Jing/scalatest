package day04

/**
  * Created by lipeijing on 2018/8/21.
  */
class ViewBoundDemo[T <% Ordered[T]] {
  def select(first: T, second: T): T = {
    if (first > second) first else second
  }
}

object ViewBoundDemo {
  def main(args: Array[String]): Unit = {
    import MyPredef.selectGirl

    val viewBoundDemo = new ViewBoundDemo[MyGirl]

    val g1 = new MyGirl("biaozi", 22, 222)
    val g2 = new MyGirl("huzi", 23, 222)

    val res = viewBoundDemo.select(g1, g2)

    println(res.name)
  }
}