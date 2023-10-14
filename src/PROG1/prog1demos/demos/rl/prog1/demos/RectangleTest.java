package PROG1.prog1demos.demos.rl.prog1.demos;

class RectangleTest {

	public static void main(String[] args) {
//		Rectangle r = new Rectangle();
//		r.width = 20;
//		r.height = 10;
//		System.out.println("l=" + r.left + " b=" + r.bottom
//				+ " w=" + r.width + " h=" + r.height);
		
//		FixedRectangle r = new FixedRectangle();
//		System.out.println(r.width);
//		r.width = 20; // error!
//		System.out.println(r.width);
		
		// code for testing
//		Rectangle r = new Rectangle();
//		r.setPos(10, 20);
//		r.setDim(4, 5);
//		r.print();
//		r.move(10, 10).print();
//		System.out.println("Bottom: " + r.bottom);
//		System.out.println("Area: " + r.getArea());
		
//		Rectangle r = new Rectangle();
//		r.setDim(4, 5);
//		r.move(10, 10).print();
//		r.move(180.0, 10.0).print();
//		r.move(270.0, 10).print(); 
		
//		System.out.println(new Rectangle());
		
//		new Rectangle().print();
//		new Rectangle(10, 10, 5).print();
//		new Rectangle(1, 2, 17, 16.0/9).print();
		
		new Rectangle(1, 2, 17, Rectangle.FOUR_THREE).print();
		Rectangle r = new Rectangle(1, 2, 17, Rectangle.SIXTEEN_NINE);
		r.print();
		System.out.println(Rectangle.getCount()); // -> 2
		//System.out.println(r.getCount()); // -> 2
		
		System.out.println(r.equals(null));
		try {
			Rectangle r2 = r.clone();
			System.out.println(r.equals(r2));
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	static class FixedRectangle {
//		public int left;
//		public int bottom;
//		public  int width = 10;
//		public final int height = 10;
//	}
	
//	static class Rectangle {
//		public int left;
//		public int bottom;
//		public  int width = 10;
//		public final int height = 10;
//	}
}
