package day06

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by lipeijing on 2018/8/22.
  */

object SparkWC {
  def main(args: Array[String]): Unit = {

    // 配置信息类
    val conf: SparkConf = new SparkConf().setAppName("SparkWC")//.setMaster("local[2]")
    // 上下文对象
    val sc: SparkContext = new SparkContext(conf)
    // 读取数据
    val lines = sc.textFile(args(0))

    // 处理数据
    val words: RDD[String] = lines.flatMap(_.split(" "))
    val paired: RDD[(String, Int)] = words.map((_, 1))
    val reduced: RDD[(String, Int)] = paired.reduceByKey(_ + _)
    val res: RDD[(String, Int)] = reduced.sortBy(_._2, false)

    // 保存
    res.saveAsTextFile(args(1))
//    println(res.collect().toBuffer)

    // 结束，释放线程
    sc.stop()
  }
}