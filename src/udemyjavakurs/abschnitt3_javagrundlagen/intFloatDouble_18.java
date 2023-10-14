package udemyjavakurs.abschnitt3_javagrundlagen;

public class intFloatDouble_18 {
    public static void main(String[] args) {
        int varZahl1 = 10/3;
        float varZahl2 = 10f/3f; //10/3 gibt 3 aus, deshalb müssen die Zahlen als float definiert werden 10f, 10f
        double varZahl3 = 10d/3d;//10/3 gibt 3 aus, deshalb müssen die Zahlen als double definiert werden 10d, 3d

        float varZahl4 = 23.34f;

        System.out.println("int " + varZahl1); //wird nicht als Kommazahl ausgegeben
        System.out.println("float " + varZahl2); //wird als Dezimalzahl ausgegeben
        System.out.println("double " + varZahl3); //wird als Dezimalzahl ausgegeben
        System.out.println("float " + varZahl4); //wird als Dezimalzahl ausgegeben
        //alles in Hochkommata "" repräsentiert einen String
        }
    }
