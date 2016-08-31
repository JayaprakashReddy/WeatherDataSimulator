package com.jpreddy.tests.weathersimulator

import org.scalatest.FlatSpec
import org.scalatest.Matchers._
import  com.jpreddy.tests.weathersimulator.datamodel.WeatherDataModel._
import com.jpreddy.tests.weathersimulator.datamodel.WeatherStation
import  com.jpreddy.tests.weathersimulator.CommonDefs._

class TestWeatherDataSimulatorApp extends FlatSpec {
  
 
  "WeatherDataSimulatorApp" should "generate weather data reading weatherstations from a file and write the generated model data to a file" in {
    
      
    val args = Array(wmoFile, weatherModelDataFile)
    WeatherDataSimulatorApp.main(args)
    
  }

  
  
}