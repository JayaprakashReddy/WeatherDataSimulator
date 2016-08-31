#WeatherDataSimulator
<p>This is weather data creation application.<br>
At the moment geography data is aggregated using apis and remote sources consists of : LATITUDE, LONGITUDE, ELEVATION, TIMEZONE. <br>
And atmosphere data generated consists of: TEMPERATURE, PRESSURE, HUMIDITY <br>
Weather condition is derived from the atmosphere elements.<br>
</p>

###Input to the application is at this location:
>src/main/resources/input/WeatherStationNames_WMO.txt

####Sample input
######LOCATION NAME|WMO CODE
Adelaide|94672 <br>
Albany|94802 <br>
Albury|94896 <br> 

###Application output is model data written at this location:
>src/main/resources/output/weather-data.csv

####Sample output
######Location|Position|Local Time|Conditions|Temperature|Pressure|Humidity
Darwin|-12.414, 130.881, 27.25|2016-08-30T21:22:22+09:30|Rainy|+46.00|996|84 <br>
Alice Springs|-23.795, 133.888, 548.0|2016-08-30T21:22:22+09:30|Sunny|+1.00|1016|14 <br>
Brisbane|-27.4, 153.1333, 1.02|2016-08-30T21:52:22+10:00|Sunny|+26.00|997|52 <br>

###The command to run test case which tests the application. This is the best method to test.
>sbt test-only com.jpreddy.tests.weathersimulator.TestWeatherDataSimulatorApp

###All the testcases can be run as follows
>sbt test

###Main application can also run as follows if we were run the application other inputs
>sbt "run path_to_input_file path_output_file"





