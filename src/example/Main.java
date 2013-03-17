/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import potentialmap.DataPoint;
import potentialmap.PotentialMapper;

/**
 *
 * @author patrick
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<DataPoint> data = new ArrayList<DataPoint>();
        Random rng = new Random();

        for (int i = 0; i < 4; i++) {
            data.add(new SimpleDataPoint(rng.nextInt(400), rng.nextInt(300), rng.nextDouble() * 2 - 1));
        }

        BufferedImage output = PotentialMapper.renderPotentialMap(data, 400, 300);
        try {
            ImageIO.write(output, "png", new File("output.png"));
        } catch (IOException ex) {
            System.out.println("Problem with IO");
        }
    }

}
