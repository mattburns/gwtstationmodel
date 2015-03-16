# GWTStationModel #

By: Matt Burns

Homepage: [www.riskaware.co.uk](http://www.riskaware.co.uk)

## Contents ##



## Overview ##

GWTStationModel is a GWT UI widget for dynamically drawing [weather station models](http://en.wikipedia.org/wiki/Station_model).

Although designed to be used as a GWT widget, the GWTStationModel is also wrapped as a [Google Chart](http://code.google.com/apis/visualization/documentation/) (aka Visualization API). This API allows you to add the GWTStationModel to any webpage (no GWT needed) with some simple javascript.

## Example ##

The [live demo](http://gwtstationmodel.googlecode.com/svn/trunk/demo/GWTStationModel.html) is an example of consuming the GWTStationModel as a Google Chart. It demonstrates the dynamic construction and modification of a station model.

Here is the full source to help you get started:

```
<html>
  <head>
  <title>GWTStationModel</title>
  <script language="javascript" src="http://www.google.com/jsapi"></script>
  <script language="javascript" src="http://gwtstationmodel.googlecode.com/svn/trunk/demo/gwtstationmodel/gwtstationmodel.nocache.js"></script>
  <style type="text/css">
    body {
      font-family: sans-serif;
      font-size: smaller;
    }
    h3 {
      margin-top:1em;
      margin-left:1em;
    }
    .formlabel {
      width:10em;
      float:left;
      margin-left:1em;
    }
    </style>
  </head>
  
  <body>
    <h3>GWTStationModel</h3>
    
    <form action="">
    <div class="formlabel">Knots:</div>
    <input id="knots" type="text" onkeyup="drawVisualization()" name="knots" value="75"/><br />
    <div class="formlabel">Degrees:</div>
    <input id="degrees" type="text" onkeyup="drawVisualization()" name="degrees" value="45"/><br />
    <div class="formlabel">Color:</div>
    <input id="color" type="text" onkeyup="drawVisualization()" name="color" value="#336699"/><br />
    <div class="formlabel">Size:</div>
    <input id="size" type="text" onkeyup="drawVisualization()" name="size" value="100"/><br />
    </form>

    <div id="mydiv"></div>
    
    <script type="text/javascript">
      // Two modules to load (Google Visualization API and the GWTStationModel)
      var num_modules = 2;
      var stationModel;
      
      // This function will be called after each module was loaded.
      function onLoadCallback() {
        // Render the visualization if this was the last module.
        if (--num_modules == 0) { 
            stationModel = new StationModelVisualization(document.getElementById('mydiv'));
            drawVisualization();   
        }
      }
        
      function drawVisualization() {
        var data = new google.visualization.DataTable();

        var knots = parseFloat(document.getElementById('knots').value);
        var degrees = parseFloat(document.getElementById('degrees').value);
        var size = parseInt(document.getElementById('size').value);
        var color = document.getElementById('color').value;
        
        data.addColumn('number', 'knots');
        data.addColumn('number', 'degrees');
        data.addRows(1);
        data.setCell(0, 0, knots);
        data.setCell(0, 1, degrees);

        stationModel.draw(data, {shaftLength: size, barbColor: color});

      }

      google.load("visualization", "1");
      google.setOnLoadCallback(onLoadCallback);
    </script>
  </body>
</html>
```

## Loading and Instantiating ##

The latest visualization javascript can be loaded directly from http://gwtstationmodel.googlecode.com/svn/trunk/demo/gwtstationmodel/gwtstationmodel.nocache.js as shown here:
```
 <script style='text/javascript' src='http://gwtstationmodel.googlecode.com/svn/trunk/demo/gwtstationmodel/gwtstationmodel.nocache.js'></script>
```
The visualization class name is StationModelVisualization. Here is an example of instantiating it in JavaScript:
```
  var visualization = new StationModelVisualization(container_div);
```

## Data Format ##

The only data that needs to be passed into the visualization is the speed in knots and the direction in degrees. Both should be non-negative floats. Since the visualization API expects data to be passed in through a DataTable, these values are simply passed in a table containing 1 row with 2 columns. Column 0 is knots, and column 1 is degrees.

```
        var data = new google.visualization.DataTable();

        var knots = 5;
        var degrees = 45;
        
        data.addColumn('number', 'knots');
        data.addColumn('number', 'degrees');
        data.addRows(1);
        data.setCell(0, 0, knots);
        data.setCell(0, 1, degrees);
```

For the generated image, the speed in knots is rounded to the nearest 5 degrees. Eg, 2.5  and 7.49 will be treated as 5 knots whereas 7.5 will be treated as 10 knots.

## Configuration Options ##

The following options can be added to the options object passed to the visualization's draw() method.

| **Name** | **Type** | **Default** | **Description** |
|:---------|:---------|:------------|:----------------|
|shaftLength|int|100|This is the length, in pixels, of the wind barb shaft.|
|barbColor|String|"black"|This will be used to determine the color of the wind barb. Any valid CSS color string will do.|

## Methods ##

| **Method** | **Return Type** | **Description** |
|:-----------|:----------------|:----------------|
|draw(data, options)|None|This will render the image. The format for the data and options objects are described above.|

## Events ##

No events are published by this visualization.

## Data Policy ##

All code and data are processed and rendered in the browser. No data is sent to any server.

## Localization ##

This visualization does not support localization.

## Notes ##

For more information, see the Google [documentation](http://code.google.com/apis/visualization/documentation/using_overview.html).

Feedback is always welcome.