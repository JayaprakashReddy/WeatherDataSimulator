package com.jpreddy.tests.weathersimulator.datasource

import com.jpreddy.tests.weathersimulator.CommonDefs._

object GeographyDataSource extends DataSource {


	def fetchElevation(api:String,LATITUDE:String,LONGITUDE:String):String= {
    val apiString =api.replace("$LATITUDE", LATITUDE).replace("$LONGITUDE", LONGITUDE)
    logger.debug(s"API call=$apiString")
    val response = scala.io.Source.fromURL(apiString).mkString
    response
  }


	def fetchMLIDMappingFile=
		{
			if(RUNMODE_FULLREFRESH ==  dataCollectionMode)  {  
					copyRemoteFile(mlidDataRemoteLocation, mlidLocalLocation)
					logger.info("MLID file refreshed")
			}
		}

}