package com.jpreddy.tests.weathersimulator.datagen

import com.jpreddy.tests.weathersimulator.CommonDefs._
import scala.util.{Try,Success,Failure}
import com.jpreddy.tests.weathersimulator.datamodel._
import com.jpreddy.tests.weathersimulator.datamodel.WeatherElementModel._
import com.jpreddy.tests.weathersimulator.datagen._
import com.jpreddy.tests.weathersimulator.utils.TransformationUtil._

object AtmosphereDataGen {
  
  def generateAtmosphereModel( WeatherStations_GeographyModel: List[(WeatherStation, GeographyModel)])={
    
    WeatherStations_GeographyModel.map(x => (x._1, x._2 ,generateAtmophereData(x._2)  ))
  }
  
  
  def  generateAtmophereData(geoModel : GeographyModel) :AtmosphereModel =
  {
    val temperature = generateTemperature(geoModel)
    val pressure = generatePressure(geoModel)
    val humidity = generateHumidity(geoModel)
    val weatherCondition =generateWeatherCondition(temperature, pressure, humidity)
    AtmosphereModel(temperature,pressure,humidity, weatherCondition)
  }
  
  def generateTemperature(geoModel : GeographyModel) :String=
  {
    //generate random number between max and min  temperatures noted on earth
    val minval = Temperature.getTemperature(geoModel.timeZone).min
    val maxval = Temperature.getTemperature(geoModel.timeZone).max
    val range = maxval - minval
    val tempI= scala.util.Random.nextInt(range.toInt)
    val tempF= scala.util.Random.nextFloat
    val tempIF =tempI + tempF
    
    val tempNew = tempIF - (- minval )
    roundAt1(tempNew.toFloat).toString
  }
  
  def generatePressure(geoModel : GeographyModel) :String=
  {
    //generate random number between max and min  temperatures noted on earth
    val minval = Pressure.getPressure(geoModel.timeZone).min
    val maxval = Pressure.getPressure(geoModel.timeZone).max
    val range = maxval - minval
    val valI  = scala.util.Random.nextInt(range.toInt)
    val valF  = scala.util.Random.nextFloat
    val valIF = valI + valF
    val valNew =  minval +valIF 
    roundAt1(valNew.toFloat).toString
  }
  
  def generateHumidity(geoModel : GeographyModel) :String=
  {
    //generate random number between max and min  temperatures noted on earth
    val minval = Humidity.getHumidity(geoModel.timeZone).min
    val maxval = Humidity.getHumidity(geoModel.timeZone).max
    val range = maxval - minval
    val valI= scala.util.Random.nextInt(range.toInt)
    val valNew = valI - (- minval )
    
    valNew.round.toString
  }
  
  def generateWeatherCondition(temperature:String, pressure:String, humidity:String):String =
  {
    logger.debug(s"temperature=$temperature, pressure=$pressure, humidity=$humidity")
    val weatherCondition =(temperature.toFloat,pressure.toFloat,humidity.toInt) match {
      case (t,p,h)  if h <=100 && h >=55 && t > 0 =>  "Rain"
      case (t,p,h)  if h <=100 && h >=55 && t <= 0 =>  "Snow"
      case _  => "Sunny"
    }
    
    weatherCondition
    
  }
  
  
  
}