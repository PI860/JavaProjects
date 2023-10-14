package PROG1.myprogrammsvorlesung.project23_POI;

/**
 * @author Paulina Pyczot
 * @date 10.01.2023
 **/
/*

public class Position (double latitude, double longitude){

    public Position(double latitude, double longitude) {
    }

    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }

    //getter Methode
    @Override
    public boolean equals(Object obj) {

        //dümmere Methode:
//        if (obj instanceof Position) {
//            Position p = (Position) obj;
//            return latitude == p.getLatitude() && longitude == p.getLongitude();
//            return super.equals(obj);
//        }
        //schlauere Methode:
        if (obj != null && getClass() == obj.getClass()) {
            POI p = (POI) obj;
            //return latitude == p.getLatitude() && longitude == p.getLongitude(); // so nicht
            return super.equals(obj) && name == p.getName();
        }
        return false;
    }

}
*/
