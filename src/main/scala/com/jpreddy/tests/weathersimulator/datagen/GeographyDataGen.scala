package com.jpreddy.tests.weathersimulator.datagen

import com.jpreddy.tests.weathersimulator.CommonDefs._
import scala.util.{Try,Success,Failure}
import com.jpreddy.tests.weathersimulator.datavalidation.DataValidationUtil
import com.jpreddy.tests.weathersimulator.datasource.GeographyDataSource
import com.jpreddy.tests.weathersimulator.datamodel._
import com.jpreddy.tests.weathersimulator.utils._
import com.jpreddy.tests.weathersimulator.utils.TransformationUtil._

/**
 * This class is responsible for generating geography data such as LATITUDE, LONGITUDE, ELEVATION 
 * data is not generated but the actual data is fetched from remote location.
 * As this remote file contains whole lot of other data, only selective data is extracted.
 */

object GeographyDataGen {
  
  /**
   * GeographyModel  object is created for the  WeatherStation  by parsing the data from a remote file
   * 
   */
  def fetchGeographyData(weatherStations: List[WeatherStation]): List[(WeatherStation, GeographyModel)] =
  {
    GeographyDataSource.fetchMLIDMappingFile
    //4. Parse MLID file and filter the COORDINATES needed for INPUT WMO stations
   val wmoCodeHeader="wmo_xref"
   val latitudeHeader="lat_prp"
   val longitudeHeader="lon_prp"
   val timeZone ="tz"
   val wmo_data = Try(scala.io.Source.fromFile(mlidLocalLocation, "ISO-8859-1").getLines().dropWhile(!_.startsWith("country3")).toArray) match {
       case Success(array) => array
       case Failure(f) => { logger.error(s"Error in processing IATA MLID mapping file $mlidLocalLocation : $f") ; Array() }
   }
    
   val header = (wmo_data.take(1).map{x => x.split(",")}.map{x => (x.indexOf(wmoCodeHeader), x.indexOf(latitudeHeader),x.indexOf(longitudeHeader), x.indexOf(timeZone))})
   val WMO =header(0)._1
   val LATITUDE =header(0)._2
   val LONGITUDE =header(0)._3
   val TZ = header(0)._4
   val wmoSet = weatherStations.map(x => (x.wmo)).toSet
   val wmo_geography_mapping_collected =wmo_data.drop(1).map(x => x.split(",")).filter(x => wmoSet.contains(x(WMO)))
   .map(x =>  (x(WMO),GeographyModel(x(LATITUDE).toFloat, x(LONGITUDE).toFloat,0f, x(TZ))) )
    
   val wmo_geography_mapping = DataValidationUtil.removeDuplicates(wmo_geography_mapping_collected).toList.sortBy( x => x._1)
  
   //Pair  WeatherStationsModel with GeographyModel
   val weatherStations_mapping = weatherStations.sortBy( x => x.wmo)
    
    val result =  weatherStations_mapping.zip(wmo_geography_mapping.map(x => x._2))
    //Fetch Eelevation info based on the latitude and longitude and update the GeographyModel
    val geographyModel = result.map(x => (x._1, x._2,fetchElevation(x._2.latitude.toString, x._2.longitude.toString)))
    .map(x => ( x._1,GeographyModel(roundAt2(x._2.latitude), roundAt2(x._2.longitude), x._3.toFloat.round, x._2.timeZone )))
    
    geographyModel
   }
  
  /**
   * Elevation data for GEO coordinates is fetched separately from another source
   */
   def fetchElevation(lat:String, lon: String) ={
     
   //FETCH ELEVATION 
      val elevationResponse= GeographyDataSource.fetchElevation(elevtionAPI,lat,lon)
      val elevationData = JSONParser.parseElevationAPIResponse(elevationResponse)
      
      val elevation = elevationData match {
        case Success(elevationInfo) => elevationInfo
        case Failure(f) => {  logger.error(s"Failure in parsing elevation response for $lat ,$lon = $f  ; API response=$elevationResponse") ; ""  }
      }
      
      elevation
   }
   
}