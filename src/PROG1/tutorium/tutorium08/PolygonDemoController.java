//package PROG1.tutorium.tutorium08;
//
//import PROG1.abgaben.uebungsblatt8.pp.prog1.exercises.set08.Point;
//import PROG1.tutorium.tutorium07.Polygon;
//import PROG1.prog1demos.demos.rl.util.painttool.AbstractController;
//import PROG1.prog1demos.demos.rl.util.painttool.DrawableObject;
//import PROG1.prog1demos.demos.rl.util.painttool.PaintTool;
//
//import java.awt.*;
//
///**
// * @author Paulina Pyczot
// * @date 24.11.2022
// **/
//
//public class PolygonDemoController extends AbstractController {
//    @Override // checkt, ob Methode überschrieben wird oder nicht
//    public String getTitle() {
//        return "Polygon Demo Controller v0";
//    }
//
//    @Override
//    public String[] getButtonNames() {
//        return new String[] {"Smooth"};
//    }
//
//    @Override
//    public void onMouseClick(PaintTool ptool, int x, int y, int mouseButton, boolean isShiftDown, boolean isControlDown) {
//        ptool.addCircle(x,y,6,true);
//    }
//
//    @Override
//    public void onButtonPressed(PaintTool ptool, int button) {
//        Point[] points = new Point[ptool.getDrawableObjects().size()];
//
//        int i = 0;
//        for (DrawableObject object : ptool.getDrawableObjects()) {
//            Point point = new Point(object.getX(), object.getY());
//            points[i++] = point;
//            System.out.println(object.getX() + " " + object.getY());
//        } // int i + for-Schleife: Jetzt stehen die Koordinaten der Drawableobjects in dem Point Array
//
//        Polygon polygon = new Polygon(points);
//        polygon.smooth();
//        points = polygon.getEdges(); // points enthält jetzt die Eckpunkte des neuen Polygons
//
//        ptool.setColor(Color.blue);
//        ptool.clearCanvas(); // löschen
//    }
//
//    //int x2 = ptool.getCanvas().getWidth(); // gibt die Breite des Java-Fensters von Painttool zurück (für den letzten x. Wert im Canvas)
//}
