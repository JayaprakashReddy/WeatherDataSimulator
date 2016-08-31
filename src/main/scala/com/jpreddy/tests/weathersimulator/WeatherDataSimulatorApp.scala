package com.jpreddy.tests.weathersimulator

import com.jpreddy.tests.weathersimulator.CommonDefs._

object WeatherDataSimulatorApp {
  
  def main(args :Array[String])=
  {
    logger.debug("WeatherDataSimulatorApp starting")
    
    val Array(inputStationsFile,weatherDataFilePath) = args
    
    val weatherStations = WeatherDataSimulator.loadWeatherStations(inputStationsFile)
    val weatherModel = WeatherDataSimulator.generateWeatherData(weatherStations)
    
    WeatherDataSimulator.storeWeatherData(weatherModel,weatherDataFilePath)
    
    logger.debug("WeatherDataSimulatorApp completed")
  }
  
}