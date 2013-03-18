package example;

import java.awt.geom.Point2D;
import potentialmap.DataPoint;

/**
 *
 * @author patrick
 */
public class SimpleDataPoint implements DataPoint {

    private double x;
    private double y;
    private double value;

    public SimpleDataPoint(double x, double y, double value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public Point2D.Double getLocation() {
        return new Point2D.Double(x, y);
    }

    public double getValue() {
        return value;
    }

}
