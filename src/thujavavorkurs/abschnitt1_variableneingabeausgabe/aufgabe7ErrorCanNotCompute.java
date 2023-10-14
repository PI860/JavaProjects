package thujavavorkurs.abschnitt1_variableneingabeausgabe;
import java.util.Scanner;

public class aufgabe7ErrorCanNotCompute {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //out statt in
		double pi = 3.1415; //, statt .
		System.out.print("Radius: ");
		double radius = scan.nextDouble();
		System.out.print("Height: "); //; fehlt
		double height = scan.nextDouble();
		double circumference = 2 * pi * (radius);
		double baseArea = pi * radius * radius; //^2 ist keine Potenz
		double lateralSurfaceArea = circumference * height;
		double surface = 2 * baseArea + lateralSurfaceArea;
		double volume = baseArea * height;
		System.out.println("Circumference: " + circumference); //" nach String setzen, nicht nach Variable!
		System.out.println("Base Area: " + baseArea);
		System.out.println("Lateral Surface Area: " + lateralSurfaceArea); //Lateral muss klein sein
		System.out.println("Surface: " + surface); //+ Operator fehlt
		System.out.println("Volume: " + volume); //) fehlt

	}

}
