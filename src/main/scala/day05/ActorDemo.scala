package day05

import scala.actors.Actor

/**
  * Created by lipeijing on 2018/8/21.
  */
object ActorDemo extends Actor{
  override def act(): Unit = {
    for (i <- 1 to 20) {
      println("actor:" + i)
      Thread.sleep(1000)
    }
  }
}

object ActorDemo2 extends Actor{
  override def act(): Unit = {
    for (i <- 1 to 20) {
      println("actor2:" + i)
      Thread.sleep(1000)
    }
  }
}

object ActorTest {
  def main(args: Array[String]): Unit = {
    ActorDemo.start()
    ActorDemo2.start()
  }
}