package com.jpreddy.tests.weathersimulator.utils

import  com.jpreddy.tests.weathersimulator.CommonDefs._
import java.text.SimpleDateFormat
import org.joda.time._
import org.joda.time.format._
import java.text.DecimalFormat
/**
 * @author JPReddy
 */
object TransformationUtil {
  
  val jodaDateTimeFormatter= DateTimeFormat.forPattern(DATETIME_FORMAT)
  
  def getCurrentDate=  {
    new java.util.Date()
  }
  
  def currentTimeAsString(timeZone:String,format :String)={
    
    val patternFormat = DateTimeFormat.forPattern(format);
    val  dt = new DateTime().withZone(DateTimeZone.forID(timeZone))
    dt.toString(patternFormat)
    
  }
  
  def currentTimeAsString(timeZone:String)={
    
    val  dt = new DateTime().withZone(DateTimeZone.forID(timeZone))
    dt.toString(jodaDateTimeFormatter)
    
  }
  
  def formatTemeperature(temp : String)={
      val tempRounded = BigDecimal(temp).setScale(1, BigDecimal.RoundingMode.HALF_UP).toDouble
      val fmt = new DecimalFormat("+##0.0;-#");
      val tempFormatted = fmt.format(tempRounded)
      tempFormatted
  }
  
  def roundAt1(f :Float)=
  {
    val fNew = (f * 10).round.toFloat /10
    
    fNew
  }
  
  def roundAt2(f :Float)=
  {
    val fNew = (f * 100).round.toFloat /100
    
    fNew
  }
 
}