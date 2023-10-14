// Gabriel Penkert bei Ruediger Lunde, Programmieren 1, Uebungsblatt 11

// disclaimer: die Anzahl der angezeigten Kerzen haengt vom Seitenverhaeltnis des Painttool-Fensters ab
package PROG1.abgaben.uebungsblatt11;

import PROG1.rl.util.painttool.*;
//import java.awt.*;
import java.awt.*;
import java.util.Random;

/**
 * @author Paulina Pyczot
 * @date 20.12.2022
 * Aufgabe 2
 **/
public class XmasController extends AbstractController {
    @Override
    public String getTitle() { return "Xmas Scene";}
    @Override
    public String[] getButtonNames() { return new String[] { "Push for Xmas Spirit"};}
    @Override
    public void onButtonPressed(PaintTool ptool, int button) {
        int cWidth = ptool.getCanvas().getWidth();
        int cHeight = ptool.getCanvas().getHeight();

        // Erstellen des Baums:
        switch (button) {
            case 0:
                ptool.clearCanvas();
                Random r = new Random();

                double xPos = cWidth * 0.25;
                double yPos = cHeight * 0.25;
                int treeWidth = (int) (Math.sqrt(cWidth * cHeight) * 0.5);
                int treeWidth2 = (int) (treeWidth * 0.15);

                ptool.setColor(Color.GREEN);
                ptool.addTriangle((int) xPos, (int) yPos, treeWidth, true);
                ptool.setColor(Color.black);
                ptool.addRectangle((int) xPos + (treeWidth / 2) - (treeWidth2 / 2), (int) yPos + treeWidth, treeWidth / 10, treeWidth2, true); // Baumstumpf wird generiert

                double[] positionTriangle = new double[]{(xPos), (yPos)};
                int y1= (int) positionTriangle[1]+treeWidth;

                for (int i = 0; i < treeWidth; i+=2) {
                    for (int j = 0; j < treeWidth-i; j+=2) {
                        int x = (int) positionTriangle[0] + (j / 2)+i;
                        int y = y1 - j;
                        int number = r.nextInt(1000);
                        if (number % 999 == 0) {
                            printCandles(ptool, x, y - 25);
                        }
                    }
                }
                break;
        }
    }

    // Erstellen der Kerzen:
    public static void printCandles (PaintTool ptool, int x, int y) {
        ptool.setColor(Color.RED);
        ptool.addRectangle(x, y, 10, 25, true);

        ptool.setColor(Color.YELLOW);
        ptool.addCircle(x + 5, y, 8, true);
    }
}
