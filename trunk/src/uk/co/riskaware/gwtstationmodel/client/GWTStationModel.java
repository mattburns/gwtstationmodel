package uk.co.riskaware.gwtstationmodel.client;

import com.google.gwt.widgetideas.graphics.client.Color;
import com.google.gwt.widgetideas.graphics.client.GWTCanvas;

public class GWTStationModel extends GWTCanvas {

    private static final int DEFAULT_BARB_LENGTH = 100;
    private static final Color DEFAULT_BARB_COLOR = new Color("#1446AA");
    private static final double SHAFT_TO_IMAGE_WIDTH_RATIO = 2.3;
    private static final int MAX_KNOTS = 190;
    private static final int MAX_LENGTH = 100000;
    private final int shaftLength;
    private final int tickLength;
    private final int tickSpacing;
    private final int width;
    private final int height;
    private final int xCenter;
    private final int yCenter;
    private final double centerRadius;

    public GWTStationModel() {
        this(DEFAULT_BARB_LENGTH);
    }

    public GWTStationModel(int shaftLength) {
        this(shaftLength, DEFAULT_BARB_COLOR);
    }

    public GWTStationModel(int shaftLength, String barbColorString) {
        this(shaftLength, new Color(barbColorString));
    }

    public GWTStationModel(int shaftLength, Color barbColor) {
        super((int) (shaftLength * SHAFT_TO_IMAGE_WIDTH_RATIO),
                (int) (shaftLength * SHAFT_TO_IMAGE_WIDTH_RATIO));

        this.shaftLength = Math.min(MAX_LENGTH, shaftLength);

        tickLength = shaftLength / 4;
        tickSpacing = tickLength / 2;
        width = (int) (shaftLength * SHAFT_TO_IMAGE_WIDTH_RATIO);
        height = width;
        xCenter = width / 2;
        yCenter = height / 2;
        centerRadius = shaftLength / 20;

        if (shaftLength > 50) {
            setLineWidth(3);
        } else {
            setLineWidth(1);
        }
        setStrokeStyle(barbColor);
        setFillStyle(barbColor);
        setLineJoin(GWTCanvas.ROUND);
        setLineCap(GWTCanvas.ROUND);
    }

    public void drawWindBarb(WindBarb windBarb) {
        double knots = windBarb.getKnots();

        knots = Math.min(MAX_KNOTS, knots);

        int endMarker = xCenter - shaftLength;

        translate(xCenter, yCenter);
        rotate(windBarb.getRadians());
        translate(-xCenter, -yCenter);

        moveTo(xCenter, yCenter - centerRadius);
        lineTo(xCenter, endMarker);

        boolean atEnd = true;
        while (knots >= 2.5) {

            if (knots >= 47.5) {
                stroke();
                beginPath();
                moveTo(xCenter, endMarker);
                lineTo(xCenter + tickLength, endMarker);
                lineTo(xCenter, endMarker + tickSpacing);
                closePath();
                fill();
                knots -= 50;
            } else if (knots >= 7.5) {
                if (atEnd) {
                    endMarker -= tickSpacing;
                }
                moveTo(xCenter, endMarker + tickSpacing);
                lineTo(xCenter + tickLength, endMarker);
                knots -= 10;
            } else {
                moveTo(xCenter, endMarker + tickSpacing);
                lineTo(xCenter + (tickLength / 2), endMarker
                        + (tickSpacing / 2));
                knots -= 5;
            }
            atEnd = false;
            moveTo(xCenter, endMarker + tickSpacing);
            endMarker += tickSpacing + 1;
        }
        stroke();
        drawCenter();

        // now rotate back again
        translate(xCenter, yCenter);
        rotate(-windBarb.getRadians());
        translate(-xCenter, -yCenter);
    }

    private void drawCenter() {
        beginPath();
        double startAngle = Math.toRadians(-90);
        double endAngle = startAngle + Math.toRadians(360);
        arc(xCenter, yCenter, centerRadius, startAngle, endAngle, true);
        fill();
    }

}
