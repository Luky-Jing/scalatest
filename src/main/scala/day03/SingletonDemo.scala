package day03

import scala.collection.mutable.ArrayBuffer

/**
  * Created by lipeijing on 2018/8/16.
  * 在Scala中没有静态方法和字段，可以使用object关键字加类名实现对应功能
  * 1、工具类、存放常量和工具方法
  * 2、实现但例模式
  */
object SingletonDemo {
  def main(args: Array[String]): Unit = {
    val factory = SessionFactory

    println(factory.getSessions)

    println(factory.getSessions.size)

    println(factory.getSessions(0))

    println(factory.removeSession)
  }
}

object SessionFactory {
  /**
    * 相当于java的静态快
    */
  println("SessionFactory被执行了")

  var i = 5

  private val session = new ArrayBuffer[Session]

  while (i > 0) {
    session += new Session
    i -= 1
  }

  def getSessions = session

  def removeSession: Unit = {
    val s = session(0)
    session.remove(0)
    println("session被移除" + s)
  }
}

class Session {

}