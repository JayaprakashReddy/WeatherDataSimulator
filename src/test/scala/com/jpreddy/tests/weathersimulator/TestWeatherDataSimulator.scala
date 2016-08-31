package com.jpreddy.tests.weathersimulator

import org.scalatest.FlatSpec
import org.scalatest.Matchers._
import  com.jpreddy.tests.weathersimulator.datamodel.WeatherDataModel._
import com.jpreddy.tests.weathersimulator.datamodel.WeatherStation


class TestWeatherDataSimulator extends FlatSpec {
  
 
  "WeatherDataSimulator" should "generate weather data for the input weather station " in {
    
      val weatherStation = WeatherStation("Alice Springs","94326")
      val weatherStations =  List[WeatherStation](weatherStation)
  
      val result =WeatherDataSimulator.generateWeatherData(weatherStations)
//      println(result)
      assert( result.head.startsWith("Alice Springs|-23.79,133.89,548|") )
      
    
  }

}