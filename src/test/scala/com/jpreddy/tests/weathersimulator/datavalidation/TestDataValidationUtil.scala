package com.jpreddy.tests.weathersimulator.datavalidation

import com.jpreddy.tests.weathersimulator.datamodel._
import org.scalatest.FlatSpec
import org.scalatest.Matchers._

class TestDataValidationUtil  extends FlatSpec{
  
  "DataValidationUtil" should "remove the duplicate entries" in {
    
    val data =List(
        ("1234" , GeographyModel(25.3f, 1001.2f, 27.25f)),
        ("1235" , GeographyModel(15.3f, 1011.2f, 17.25f)), 
        ("1234" , GeographyModel(29.3f, 1001.2f, 27.25f)), 
        ("1236" , GeographyModel(16.3f, 1021.2f, 15.25f))
        )
        
    val result = DataValidationUtil.removeDuplicates(data)
//    println(result)
    result should equal(List( ("1234" , GeographyModel(25.3f, 1001.2f, 27.25f)), ("1235" , GeographyModel(15.3f, 1011.2f, 17.25f)),("1236" , GeographyModel(16.3f, 1021.2f, 15.25f))))
  }
  
}