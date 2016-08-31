package com.jpreddy.tests.weathersimulator
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import com.typesafe.config.ConfigFactory
import com.typesafe.config.Config

/**
 * All the common definitions and configurations are defined here
 */
object CommonDefs {
  
  //statics
   val DATETIME_FORMAT ="yyyy-MM-dd'T'HH:mm:ssZZ"
   val RUNMODE_FULLREFRESH= "FULL_REFRESH"
  
  //configs
  lazy val logger = LoggerFactory.getLogger("com.jpreddy.tests.weathersimulator")
  lazy val config=ConfigFactory.load("app")
  lazy val debug =config.getString("debug").toBoolean
  lazy val weatherStationsFile =config.getString("weatherstations.wmo.codes.file")
  lazy val projectResourcesRoot = config.getString("project.resources.root")
  lazy val projectInputRoot = config.getString("project.input.root")
  lazy val wmoFile = projectInputRoot+java.io.File.separator+weatherStationsFile
  lazy val projectOutputRoot = config.getString("project.output.root")
  lazy val dataCollectionMode = config.getString("data.collection.mode")
  lazy val mlidDataRemoteLocation=config.getString("wmo.mlid.mapping.file")
	lazy val mlidFileName = config.getString("mlid.local.filename")
  lazy val mlidLocalLocation = projectOutputRoot+ java.io.File.separator+ mlidFileName
  lazy val elevtionAPI= config.getString("geography.elevation.api")
  lazy val weatherModelDataFile = config.getString("weather.model.data.filename")
  lazy val weatherModelDataFilePath = projectOutputRoot+java.io.File.separator+weatherModelDataFile
}
