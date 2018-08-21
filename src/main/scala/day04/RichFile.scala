package day04

import scala.io.Source

class RichFile(val file: String) {

  def read(): String = {
    Source.fromFile(file).mkString
  }
}

object RichFile {
  def main(args: Array[String]): Unit = {
//    val file = "D:\\Office\\IdeaProjects\\scalatest\\src\\main\\scala\\day04\\CurryingDemo.scala"
//    val content: String = new RichFile(file).read()
//    println(content)

    import day04.MyPredef.fuileToRichFile
    val file = "D:\\Office\\IdeaProjects\\scalatest\\src\\main\\scala\\day04\\CurryingDemo.scala"
    val content = file.read()

    println(content)
  }
}