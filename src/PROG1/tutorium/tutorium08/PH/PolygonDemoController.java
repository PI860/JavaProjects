//package programming1lunde.tutorium.tutorium08.PH;
//
//import programming1lunde.abgaben.uebungsblatt8.rl.util.painttool.AbstractController;
//import programming1lunde.abgaben.uebungsblatt8.rl.util.painttool.DrawableObject;
//import programming1lunde.abgaben.uebungsblatt8.rl.util.painttool.PaintTool;
//
//import java.awt.*;
//
//public class PolygonDemoController extends AbstractController {
//
//    @Override
//    public String getTitle() {
//        return "Polygon Demo Controller v0";
//    }
//
//    @Override
//    public void onMouseClick(PaintTool ptool, int x, int y,
//                             int mouseButton, boolean isShiftDown,
//                             boolean isControlDown) {
//        ptool.setColor(Color.GREEN);
//        ptool.addCircle(x,y,5,true);
//    }
//
//    @Override
//    public String[] getButtonNames() {
//        return new String[] {"Smooth"};
//    }
//
//    @Override
//    public void onButtonPressed(PaintTool ptool, int button) {
//        Point[] points = new Point[ptool.getDrawableObjects().size()];
//        int i = 0;
//        for(DrawableObject object : ptool.getDrawableObjects()) {
//            Point point = new Point(object.getX(), object.getY());
//            points[i++] = point;
//            // System.out.println(object.getX() + " " + object.getY());
//        } // Jetzt stehen die Koordinaten der Drawableobjects in dem Point Array
//
//        Polygon polygon = new Polygon(points);
//        //polygon.smooth();
//        points = polygon.getEdges(); // points enthält jetzt die Eckpunkte des neuen Polygons
//        ptool.setColor(Color.blue);
//        ptool.clearCanvas();
//
//        for(Point point : points) {
//            ptool.addCircle((int)point.getX(), (int)point.getY(), 7, true);
//        }
//
//        int x2 = ptool.getCanvas().getWidth(); // "letzer x-Wert im Canvas"
//    }
//}
