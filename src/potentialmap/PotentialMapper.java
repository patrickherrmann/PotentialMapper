/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package potentialmap;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Collection;

/**
 *
 * @author patrick
 */
public class PotentialMapper {

    public static BufferedImage renderPotentialMap(Collection<DataPoint> data, int width, int height, Rectangle2D.Double rect) {

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        double pixelWidth = rect.getWidth() / width;
        double pixelHeight = rect.getHeight() / height;

        Point2D.Double location;
        Point2D.Double datumLocation;

        double dx, dy, d2, v;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                location = new Point2D.Double(rect.x + pixelWidth * x, rect.y + pixelHeight * y);

                v = 0;

                for (DataPoint datum : data) {
                    datumLocation = datum.getLocation();
                    dx = datumLocation.x - location.x;
                    dy = datumLocation.y - location.y;
                    d2 = dx * dx + dy * dy;
                    v += datum.getValue() / (d2 / 200 + 1);
                }

                float h = (float) (0.6 * v + 0.25);
                image.setRGB(x, y, Color.HSBtoRGB(h, 0.9f, 1.0f));
            }
        }

        return image;
    }

    public static BufferedImage renderPotentialMap(Collection<DataPoint> data, int width, int height) {
        return renderPotentialMap(data, width, height, new Rectangle2D.Double(0, 0, width, height));
    }
}
