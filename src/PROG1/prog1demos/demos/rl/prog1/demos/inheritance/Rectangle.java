package programming1lunde.prog1demos.demos.rl.prog1.demos.inheritance;


public interface Rectangle {
	public int getLeft();

	public int getRight();

	public int getBottom();

	public int getTop();

	public int getWidth();

	public int getHeight();

	public int getArea();
	
	public boolean isDisjoint(Rectangle r);
}
