package com.jpreddy.tests.weathersimulator.utils

import java.io._
import scala.util.Try
import com.jpreddy.tests.weathersimulator.CommonDefs._

object FileIOUtil {
  
  def writeToFile(header: String, data:List[String], file:String):Try[Boolean]={
    
    logger.debug(s"Writing data to file $file")
    Try{
    val pw =new PrintWriter(file)
    pw.println(header)
    data.foreach{ pw.println(_)}
    pw.close
    
    true
    }
  }
}