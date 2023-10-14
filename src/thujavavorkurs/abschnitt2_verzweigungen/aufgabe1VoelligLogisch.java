package thujavavorkurs.abschnitt2_verzweigungen;

public class aufgabe1VoelligLogisch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 4;
		int b = 3;
		int c = 3;
		double d = 4.5;
		int e = 1;

		/*
		 * a != 4 		-> false;
		 * a > b 		-> true;
		 * b == c		-> true;
		 * (b+1) == 4 	-> true;
		 * (a/b) == 1 	-> true;
		 * (b/a) > 0	-> false;
		 * (a%e) != 0	-> false;
		 * (a>0)&&(a<=4)-> true;
		 * !(e<c)		-> false;
		 */

		System.out.println(!(e < c));
	}

}
