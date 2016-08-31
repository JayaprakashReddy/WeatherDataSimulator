package com.jpreddy.tests.weathersimulator

import com.jpreddy.tests.weathersimulator.CommonDefs._

object WeatherDataSimulatorApp {
  
  /**
   * This is the main class to invoke the application
   * It take two inputs
   *   paramter1 : InputFilePath ( File containing WeatherStationName and its WMO code )
   *   paramter2 : outFilePath   ( File where the generated model to be written to )
   * 
   */
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