package com.jpreddy.tests.weathersimulator.utils

import org.scalatest.FlatSpec
import org.scalatest.Matchers._

class TestTransformationUtil extends FlatSpec{
  
  "TransformationUtil "  should "transform current datetime into timezone " in {
    
    val tz="Australia/Perth"
    val result= TransformationUtil.currentTimeAsString(tz)
    println(result)
  }
  
  "TransformationUtil "  should "format temperature" in {
    
    val tempN = "-25.678"
    val tempFormattedN = TransformationUtil.formatTemeperature(tempN)
    tempFormattedN should equal("-25.7")
    
    val tempP = "26.85"
    val tempFormattedP = TransformationUtil.formatTemeperature(tempP)
    tempFormattedP  should equal("+26.9")
  }
  
}