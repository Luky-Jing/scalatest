package day05

import scala.actors.{Actor, Future}
import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * Created by lipeijing on 2018/8/21.
  */
object ActionWordCount {

  def main(args: Array[String]): Unit = {
    val replys: ListBuffer[Future[Any]] = new ListBuffer[Future[Any]]

    // 存放有值Future数据
    val res: ListBuffer[Map[String, Int]] = new ListBuffer[Map[String, Int]]

    val files: Array[String] = Array("C:\\Users\\lipeijing\\Desktop\\all-hosts", "C:\\Users\\lipeijing\\Desktop\\nscd.conf", "C:\\Users\\lipeijing\\Desktop\\replication-offset-checkpoint")
    for (file <- files) {
//      val lines: List[String] = Source.fromFile(file).getLines().toList
//      val words: List[String] = lines.flatMap(_.split(" "))
//
//      val res = words.map((_, 1)).groupBy(_._1).mapValues(_.size)

      val task = new Task
      task.start()

      val reply: Future[Any] = task !! SmTask(file)

      replys += reply

    }

    while (replys.size > 0) {
      // 过滤每个future对象,过滤none类型
      val dones = replys.filter(_.isSet)
      for (done <- dones) {
        res += done.apply().asInstanceOf[Map[String, Int]]

        replys -= done
      }
    }

    for (i <- res.flatten.groupBy(_._1).mapValues(_.foldLeft(0)(_ + _._2))) {
      println("key: " + i._1 + ", value: " + i._2)
    }
  }
}

class Task extends Actor {
  override def act(): Unit = {
    while (true) {
      receive({
        case SmTask(file) => {
          val lines: List[String] = Source.fromFile(file).getLines().toList
          val words: List[String] = lines.flatMap(_.split(" "))
          val res: Map[String, Int] = words.map((_, 1)).groupBy(_._1).mapValues(_.size)

          // 异步发送结果数据,没有返回值
          sender ! res
        }
      })
    }
  }
}

case class SmTask(file: String)