package uk.co.riskaware.gwtstationmodel.client;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.AbstractDrawOptions;
import com.google.gwt.visualization.client.AbstractVisualization;

class StationModelVisualization extends AbstractVisualization<StationModelVisualization.Options> {

    /**
     * Drawing options supported by this visualization.
     */
    public static class Options extends AbstractDrawOptions {
        protected Options() {
        }

        public final native int getShaftLength() /*-{
                                                 return this.shaftLength || 100;
                                                 }-*/;

        public final native void setShaftLength(int length) /*-{
                                                            this.shaftLength = length;
                                                            }-*/;

        public final native String getBarbColor() /*-{
                                                  return this.barbColor || "black";
                                                  }-*/;

        public final native void setBarbColor(String color) /*-{
                                                            this.barbColor = color;
                                                            }-*/;
    }

    private final FlowPanel panel = new FlowPanel();

    public StationModelVisualization() {
        initWidget(panel);
    }

    @Override
    public void draw(AbstractDataTable dataTable, Options options) {
        panel.clear();

        GWTStationModel stationModel = new GWTStationModel(options.getShaftLength(),
                options.getBarbColor());
        panel.add(stationModel);

        for (int row = 0; row < dataTable.getNumberOfRows(); row++) {
            stationModel.drawWindBarb(new WindBarb(dataTable
                    .getValueInt(row, 0), dataTable.getValueInt(row, 1)));
        }

    }
}
