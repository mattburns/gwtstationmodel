Automatically exported from code.google.com/p/gwtstationmodel

## Introduction
GWTStationModel is a GWT UI widget for dynamically drawing [http://en.wikipedia.org/wiki/Station_model weather station models].

View the [http://gwtstationmodel.googlecode.com/svn/trunk/demo/GWTStationModel.html live demo] for an idea of the images produced.


## GWT Usage
GWTStationModel is an extension of [http://code.google.com/p/google-web-toolkit-incubator/wiki/GWTCanvas GWTCanvas] and can be simply added to your GWT application in the same way.
Download the latest [http://gwtstationmodel.googlecode.com/svn/trunk/gwtstationmodel.jar gwtstationmodel.jar] and add it to your GWT project.

You'll need to add the following line to your GWT module XML:
```
<inherits name='uk.co.riskaware.gwtstationmodel.GWTStationModel' />
```

See also [http://code.google.com/p/gwt-google-apis/wiki/VisualizationGettingStarted GWT Visualizations] and the [http://code.google.com/p/google-web-toolkit-incubator/ GWT Incubator].

##Google Chart
The GWTStationModel is also wrapped as a [http://code.google.com/apis/visualization/documentation/ Google Chart] (aka Visualization API). This API allows you to add the GWTStationModel to any webpage (no GWT needed) with some simple javascript. The [http://gwtstationmodel.googlecode.com/svn/trunk/demo/GWTStationModel.html live demo] is an example of consuming the GWTStationModel as a Google Chart. For more information, see the VisualizationDocumentation.
