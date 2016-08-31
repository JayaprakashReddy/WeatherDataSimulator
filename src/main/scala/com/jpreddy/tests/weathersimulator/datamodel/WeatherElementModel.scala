package com.jpreddy.tests.weathersimulator.datamodel
import com.jpreddy.tests.weathersimulator.CommonDefs._
import scala.util.regexp._

/**
 * The static data related to WeatherElements is captured here
 */

object WeatherElementModel {
 
  class AtmosphericWeatherElement(val name:String,
    val unit : String,
    val min : Double,
    val max : Double) 


  class Temperature(name:String,unit : String,min : Double, max : Double) extends AtmosphericWeatherElement(name, unit,min,max)
   object Temperature{
    def getTemperature(tz:String)= {
      val pattern = "(Australia.*)".r
      tz match
    {
        case pattern(timezone) => { logger.debug(s"Timezone =$timezone"); new Temperature(name="Temperature", unit="Celcius",min= -10d,max= +50d) }
        case _ => new Temperature(name="Temperature", unit="Celcius",min= -90d,max= +60d)
    }
    }
  }

class Pressure(name:String,unit : String,min : Double, max : Double) extends AtmosphericWeatherElement(name, unit,min,max)
   object Pressure{
    def getPressure(tz:String)= {
      val pattern = "(Australia.*)".r
      tz match
    {
        case pattern(timezone) => { logger.debug(s"Timezone =$timezone"); new Pressure(name="Pressure", unit="hPa",min= 965,max= 1020) }
        case _ => new Pressure(name="Pressure", unit="hPa",min= 8790,max= 1085)
    }
    }
  }


class Humidity(name:String,unit : String,min : Double, max : Double) extends AtmosphericWeatherElement(name, unit,min,max)
   object Humidity{
    def getHumidity(tz:String)= {
      val pattern = "(Australia.*)".r
      tz match
    {
        case pattern(timezone) => { logger.debug(s"Timezone =$timezone"); new Humidity(name="Pressure", unit="%",min= 0,max= 100) }
        case _ => new Humidity(name="Pressure", unit="%",min= 0,max= 100)
    }
    }
  }
}