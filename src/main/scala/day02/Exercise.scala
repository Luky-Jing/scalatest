package day02

object Exercise {
  def main(args: Array[String]): Unit = {
//    val list0 = List(1, 2, 3, 5, 9, 22, 44, 6)
//    println(list0)
//    val list1 = list0.map(_ * 2)
//    println(list1)
//
//    val list2 = list0.filter(_ % 2 == 0)
//    println(list2)
//
//    val list3 = list0.sorted
//    println(list3)
//
//    val list4 = list0.sorted.reverse
//    println(list4)
//
//    val it = list0.grouped(4)
//    println(it.toBuffer)
//
//    val list5 = it.toList
//    println(list5)
//
//    val list6 = list5.flatten
//    println(list6)
//
//    val lines = List("hello java hello scala", "hello python hello scala")
//    val words = lines.map(_.split(" "))
//    println(words)
//    val flatwords = words.flatten
//    println(flatwords)
//
//    val res = lines.flatMap(_.split(" "))
//    println(res)

    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//    val res = arr.sum
//    println(res)

//    val res = arr.par.sum
//    println(res)

//    val res = arr.reduce(_+_)
//    val res = arr.reduceLeft(_-_)

//    val res = arr.par.fold(10)(_+_)

//    val res = arr.foldLeft(10)(_+_)
//    println(res)

    val list1 = List(List(1, 2, 3, 4), List(5, 6, 7, 8, 9))
//    val res = list1.flatten.reduce(_+_)

//    val res = list1.aggregate(0)(_+_.sum, _+_)

    val l1 = List(1, 2, 3)
    val l2 = List(2, 3, 4)

//    val res = l1 union l2
//    val res = l1 intersect  l2
    val res = l1 diff l2
    println(res)

  }
}

