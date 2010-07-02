package uk.co.riskaware.gwtstationmodel.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.visualization.client.AbstractVisualization;
import com.google.gwt.visualization.client.AbstractVisualization.VisualizationFactory;

/**
 * The EntryPoint implementation for the GWT application.
 * 
 */
class GWTStationModelEntryPoint implements EntryPoint {

    private static native void callOnLoadCallback(String name) /*-{
        if ($wnd.onLoadCallback != undefined) {
        $wnd.onLoadCallback(name);
        }
    }-*/;

    public GWTStationModelEntryPoint() {
    }

    public void onModuleLoad() {

        // Register the visualization
        AbstractVisualization.registerVisualization("GWTStationModel",
                new VisualizationFactory() {
                    public AbstractVisualization<?> create() {
                        return new GWTStationModel();
                    }
                });

        callOnLoadCallback(GWT.getModuleName());
    }
}
