package day04

/**
  * Created by lipeijing on 2018/8/21.
  */
class UpperBoundDemo[T <: Comparable[T]] {
  def select(first: T, second: T): T = {
    if (first.compareTo(second) > 0)
      return first
    else
      return second
  }
}

object UpperBoundDemo {
  def main(args: Array[String]): Unit = {
    val u = new UpperBoundDemo[MissRight]

    val m1 = new MissRight("biaozhuan", 90)
    val m2 = new MissRight("baobiao", 80)

    val res = u.select(m1, m2)
    println(res.name)
  }
}

class MissRight(val name: String, val faceValue: Int) extends Comparable[MissRight] {
  override def compareTo(o: MissRight): Int = {
    this.faceValue - o.faceValue
  }
}