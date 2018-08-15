package day02

/**
  * Created by lipeijing on 2018/8/15.
  */
object ScalaWordCount {
  def main(args: Array[String]): Unit = {
    val lines = List("hello java hello python", "hello scala", "hello java hello scala")
    //切分 亚平
    val words = lines.flatMap(_.split(" "))
    println(words)

    //把单词生成pair
    val tuples = words.map((_, 1))
    println(tuples)

    //以key进行分组
    val grouped = tuples.groupBy(_._1)
    println(grouped)

    //统计value的长度
    val count = grouped.mapValues(_.size)
    println(count)

    val sorted = count.toList.sortBy(_._2).reverse
    println(sorted)
  }
}