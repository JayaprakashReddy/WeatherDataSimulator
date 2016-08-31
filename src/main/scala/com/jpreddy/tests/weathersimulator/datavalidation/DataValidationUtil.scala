package com.jpreddy.tests.weathersimulator.datavalidation

import com.jpreddy.tests.weathersimulator.datamodel._
object DataValidationUtil {
  
 
  def removeDuplicates(data :Seq[(String,GeographyModel)])=
  {
    val result =data.groupBy(_._1).map { x => x match{
      case (k,v) =>  v.head
      } 
    }
    val soretedResult = result.toList.sortBy(_._1)
    
  soretedResult
  }
  
}