package com.jpreddy.tests.weathersimulator

import com.jpreddy.tests.weathersimulator.CommonDefs._
import scala.util.{Try,Success,Failure}
import com.jpreddy.tests.weathersimulator.datamodel._
import com.jpreddy.tests.weathersimulator.datagen._
import com.jpreddy.tests.weathersimulator.utils.FileIOUtil._

object WeatherDataSimulator {
  
  def loadWeatherStations(wmoFile: String):List[WeatherStation] =
  {
    
   //1. Input feed containing WeatherStationName with WMO code
   logger.info(s"weather stations input file is read from this location =$wmoFile")
   val weatherstations = Try{scala.io.Source.fromFile(wmoFile)
     .getLines().filter(!_.startsWith("#")).map(_.split("\\|"))
     .map(x =>WeatherStation(x(0),x(1))).toList}  match {
     case Success(list) => list
     case Failure(f) => { logger.error(s"Error in processing WMO codes file $wmoFile : $f") ; List[WeatherStation]()}
   }
     
   logger.info(s"The number of weather stations in the input file = ${weatherstations.length}")
     
   weatherstations
  }
  
  def generateWeatherData(weatherStations :List[WeatherStation]):  List[String]=
  {
   logger.debug("WeatherDataSimulator.generateWeatherData started")
   

   //Generate Geography Data
   val weatherStaionGeographyModel= GeographyDataGen.fetchGeographyData(weatherStations)

   //Generate Atmosphere Data
   val aggregatedModelList = AtmosphereDataGen.generateAtmosphereModel(weatherStaionGeographyModel)

   val weatherModel = aggregatedModelList.map(aggregatedModel => WeatherDataModel.createWeatherDataModel(aggregatedModel)).map(_.toString())
   
   logger.info(s"weather model is generated for the input stations")
   
   weatherModel
   }
  
  def storeWeatherData(weatherModel :List[String],outputFilePath: String)=
  {
   
   logger.info(s"weather model data File =  $outputFilePath")
   
   //Generated weather model is written to file
   writeToFile(WeatherDataModel.getHeader, weatherModel,weatherModelDataFilePath) match {
        case Success(status)  => if(status) logger.info(s"model data successfully written to file $weatherModelDataFilePath") 
                                 else logger.info(s"Application data has some issues in writing to file") 
        case Failure(f)  =>  logger.error(s"Error in writng model data to file")
      }
  }
  
}