package PROG1.prog1demos.demos.rl.prog1.demos;

public class PascalsTriangle {

	public static int[][] createTriangle(int hight) {
		int[][] result = new int[hight][];
		for (int i = 0; i < hight; i++) {
			result[i] = new int[i+1];
			result[i][0] = 1;
			result[i][i] = 1;
			for (int j = 1; j < i; j++)
				result[i][j] = result[i-1][j-1] + result[i-1][j];
		}
		return result;
	}
	
	public static void printTriangle(int[][] triangle) {
		for (int i = 0; i < triangle.length; i++) {
			int[] row = triangle[i];
			for (int j = 0; j < triangle.length - row.length; j++)
				System.out.print("  ");
			for (int j = 0; j < row.length; j++)
				System.out.printf("%4d", row[j]);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] triangle = createTriangle(8);
		printTriangle(triangle);
	}
}
