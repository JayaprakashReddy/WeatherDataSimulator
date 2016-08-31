package com.jpreddy.tests.weathersimulator.datagen

import org.scalatest.FlatSpec
import org.scalatest.Matchers._
import com.jpreddy.tests.weathersimulator.datamodel.GeographyModel
import com.jpreddy.tests.weathersimulator.datamodel.WeatherElementModel._

class TestAtmosphereDataGen extends FlatSpec {
  
  val geographyModel = new GeographyModel(-12.41f,130.88f,27.0f,"Australia/Darwin")

  
   "AtmosphereDataGen" should "generate Temperature with GeogrpahyModel" in {
    
    val temperature = AtmosphereDataGen.generateTemperature(geographyModel)
    println(temperature)
    val temperatureObject =Temperature.getTemperature(geographyModel.timeZone)
    
   assert(temperature.toFloat  < temperatureObject.max)
   assert(temperature.toFloat  >= temperatureObject.min)
    
   }
  
   "AtmosphereDataGen" should "generate Pressure with GeogrpahyModel" in {
    
    val pressure = AtmosphereDataGen.generatePressure(geographyModel)
    println(pressure)
    val pressureObject =Pressure.getPressure(geographyModel.timeZone)
    
   assert(pressure.toFloat  < pressureObject.max)
   assert(pressure.toFloat  >= pressureObject.min)
    
   }
   
   "AtmosphereDataGen" should "generate Humidity with GeogrpahyModel" in {
    
    val humidity = AtmosphereDataGen.generateHumidity(geographyModel)
    val humidityObject =Humidity.getHumidity(geographyModel.timeZone)
    
   assert(humidity.toFloat  < humidityObject.max)
   assert(humidity.toFloat  >= humidityObject.min)
    
   }
   
   "AtmosphereDataGen" should "generate WeatherCondition with other Atmosphere elements" in {
    
     val temperature= "-10.0"
     val pressure = "980"
     val humidity = "98"
     
    val weatherCondition = AtmosphereDataGen.generateWeatherCondition(temperature, pressure, humidity)
    weatherCondition  should equal("Snow")
    
   }
}