package PROG1.abgaben.uebungsblatt11;

import PROG1.rl.util.painttool.PaintTool;

/**
 * @author Paulina Pyczot
 * @date 20.12.2022
 * Aufgabe 1
 **/
public class XmasApp {
    public static void main(String[] args) {
        PaintTool ptool = new PaintTool(new XmasController());
        ptool.setVisible(true);
    }
}