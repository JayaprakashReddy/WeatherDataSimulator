package com.jpreddy.tests.weathersimulator.utils

import org.scalatest.FlatSpec
import org.scalatest.Matchers._
import scala.util.Success

class TestJSONParser extends FlatSpec{
  
  "JSONParser" should "parse elevation api response " in{
    
    val response = """
      {
   "results" : [
      {
         "elevation" : 3.122000694274902,
         "location" : {
            "lat" : -34.95,
            "lng" : 138.533
         },
         "resolution" : 38.17580795288086
      }
   ],
   "status" : "OK"
   }
      """
    val elevation =JSONParser.parseElevationAPIResponse(response)
    assert(elevation ==Success("3") )
  }
  
}