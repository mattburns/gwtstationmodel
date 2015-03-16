## Introduction ##
GWTStationModel is a GWT UI widget for dynamically drawing [weather station models](http://en.wikipedia.org/wiki/Station_model).

View the [live demo](http://gwtstationmodel.googlecode.com/svn/trunk/demo/GWTStationModel.html) for an idea of the images produced.


### GWT Usage ###
GWTStationModel is an extension of [GWTCanvas](http://code.google.com/p/google-web-toolkit-incubator/wiki/GWTCanvas) and can be simply added to your GWT application in the same way.
Download the latest [gwtstationmodel.jar](http://gwtstationmodel.googlecode.com/svn/trunk/gwtstationmodel.jar) and add it to your GWT project.

You'll need to add the following line to your GWT module XML:
```
<inherits name='uk.co.riskaware.gwtstationmodel.GWTStationModel' />
```

See also [GWT Visualizations](http://code.google.com/p/gwt-google-apis/wiki/VisualizationGettingStarted) and the [GWT Incubator](http://code.google.com/p/google-web-toolkit-incubator/).

### Google Chart ###
The GWTStationModel is also wrapped as a [Google Chart](http://code.google.com/apis/visualization/documentation/) (aka Visualization API). This API allows you to add the GWTStationModel to any webpage (no GWT needed) with some simple javascript. The [live demo](http://gwtstationmodel.googlecode.com/svn/trunk/demo/GWTStationModel.html) is an example of consuming the GWTStationModel as a Google Chart. For more information, see the VisualizationDocumentation.