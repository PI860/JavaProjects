package PROG1.prog1demos.demos.rl.prog1.demos;

public class Demo {
	int field1;
	static int field2;
	
	void m1() {
		int var = 1;
		field2++;
		field1++;
		System.out.println(var + " " + field1 + " " + field2);
	}
	void m2() {
		int var = 2;
		field2++;
		field1++;
		System.out.println(var + " " + field1 + " " + field2);
		m1();
		System.out.println(var + " " + field1 + " " + field2);
	}

	public static void main(String[] args) {
		Demo demo1 = new Demo();
		System.out.println(demo1.field1 + " " + field2);
		demo1.m1();
		Demo demo2 = new Demo();
		demo2.m2();
	}
}
