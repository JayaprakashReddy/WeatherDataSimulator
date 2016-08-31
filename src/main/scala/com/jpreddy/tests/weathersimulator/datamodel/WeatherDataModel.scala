package com.jpreddy.tests.weathersimulator.datamodel

import scala.collection.mutable.ListBuffer
import com.jpreddy.tests.weathersimulator.utils.TransformationUtil

/**
 * All the WeatherDataModel classes are here
 */
case class WeatherStation(label:String,wmo :String)
case class GeographyModel(latitude: Float, longitude: Float, elevation: Float, timeZone: String="")
object GeographyModel{
  
  def getGeographyForWMO(wmo_code :String) :GeographyModel=
  {
    new GeographyModel(0f, 0f, 0f,"")
  }
}
case class AtmosphereModel(temperature: String, pressure: String,humidity:String, weatherCondition:String)

case class WeatherDataModel(var weatherStation:WeatherStation,var geography: GeographyModel, var atmosphere:AtmosphereModel ){
  
  override def toString:String={
    
    val location = weatherStation.label
    val position = new String(s"${geography.latitude},${geography.longitude},${geography.elevation.round}")
    val datetime = TransformationUtil.currentTimeAsString(geography.timeZone)
    val conditions = atmosphere.weatherCondition
    val temperature = TransformationUtil.formatTemeperature(atmosphere.temperature)
    val pressure = atmosphere.pressure
    val humidity = atmosphere.humidity
    val modelElements = ListBuffer(location, position, datetime, conditions, temperature, pressure, humidity)
    
   modelElements.mkString("|")
    
  }
}


object WeatherDataModel{
  
    def getHeader:String ={
       val headerElements = ListBuffer("Location", "Position", "Local Time", "Conditions", "Temperature", "Pressure", "Humidity")
        "#"+headerElements.mkString("|")
    }
    def createWeatherDataModel(aggregatedModel:(WeatherStation, GeographyModel, AtmosphereModel)):WeatherDataModel=
    {
      val weatherDataModel=new WeatherDataModel(aggregatedModel._1, aggregatedModel._2, aggregatedModel._3)
      
      weatherDataModel
    }
  
}