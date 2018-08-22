package day05

import scala.actors.Actor

/**
  * Created by lipeijing on 2018/8/21.
  * 用actor实现同步和异步消息的发送和消息接受
  */
class ActorDemo3 extends Actor{
  override def act(): Unit = {
    while (true) {
      // 偏函数
      receive {
        case "start" => println("Starting......")
        case AsynMsg(id, msg) => {
          println(s"id: $id, AsynMsg: $msg")
          Thread.sleep(2000)
          sender ! ReplyMsg(5, "success")
        }
        case SyncMsg(id, msg) => {
          println(s"id: $id, SyncMsg: $msg")
          Thread.sleep(2000)
          sender ! ReplyMsg(5, "success")
        }
      }
    }
  }
}

object ActorDemo3 {
  def main(args: Array[String]): Unit = {

    val actorDemo3: ActorDemo3 = new ActorDemo3
    actorDemo3.start()

    // 异步发送消息，没有返回值
//    actorDemo3 ! AsynMsg(1, "Hi~ Honey")
//
//    println("没有返回值的异步消息发送完成")
//
//    // 同步发送消息，有返回值
//    val content: Any = actorDemo3 !? SyncMsg(2, "Hi~ Li")
//    println("有返回值的同步消息发送完成")
//    println(content)

    // 异步发送消息，有返回值，返回类型Future[Any]
    val reply = actorDemo3 !! AsynMsg(3, "Hi~ pei")
    Thread.sleep(3000)
    if (reply.isSet) {
      val value = reply.apply()
      println(value)
    } else {
      println("None")
    }
  }
}

case class AsynMsg(id: Int, msg: String)
case class SyncMsg(id: Int, msg: String)
case class ReplyMsg(id: Int, msg: String)