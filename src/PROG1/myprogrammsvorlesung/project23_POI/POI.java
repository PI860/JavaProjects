package PROG1.myprogrammsvorlesung.project23_POI;

/**
 * @author Paulina Pyczot
 * @date 10.01.2023
 **/
/*
public class POI extends Position{ // points of interest
    private final String name;

    public POI(double latitude, double longitude, String name) {
        super(latitude,longitude);
        this.name = name;
    }
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
            return super.equals(obj) && name.equals(p.getName());
        }
        return false;
    }

}
*/