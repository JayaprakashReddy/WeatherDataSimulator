package com.jpreddy.tests.weathersimulator.utils
import org.json4s.jackson.JsonMethods._
import org.json4s.jvalue2monadic
import org.json4s.string2JsonInput
import scala.math.BigDecimal
import java.text.DecimalFormat
import scala.util.{Try,Success,Failure}
/**
 * @author JPReddy
 */
object JSONParser extends App {
  
  def parseElevationAPIResponse(elevationResponse :String):Try[String]=
  {
    Try{
    val json = parse(elevationResponse)
    val elevationValue = compact(json \\ "elevation").replaceAll("\"","")
    val eleVationRounded = BigDecimal(elevationValue).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble.round
    eleVationRounded.toString
    }
  }
  
}