package ALGO.pp.aufgabenblaetter.blatt04;

////JUnit 4
//import static org.junit.Assert.*;
//import org.junit.Test;

//JUnit 5 (Jupiter)
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class JuTestTaskListReorder {

	@Test
	public void test0() {
		TaskList tl0 = new TaskList(10);
		// empty list
		TaskDemo.reorderTasks(tl0);
		assertTrue(tl0.isOrdered());
	}
	
	@Test
	public void test1() {
		TaskList tl1 = new TaskList(100);
		tl1.add(new Task(Priority.MEDIUM, "Task1"));
		tl1.add(new Task(Priority.HIGH, "Task2"));
		tl1.add(new Task(Priority.LOW, "Task3"));
		tl1.add(new Task(Priority.LOW, "Task4"));
		tl1.add(new Task(Priority.HIGH, "Task5"));
		tl1.add(new Task(Priority.MEDIUM, "Task6"));

		assertFalse(tl1.isOrdered());

		
		TaskDemo.reorderTasks(tl1);

		assertTrue(tl1.isOrdered());
	}
	
	@Test
	public void test2() {
		TaskList tl2 = TaskDemo.generateRandomList(10);
		TaskDemo.reorderTasks(tl2);
		assertTrue(tl2.isOrdered());
	}
	
	@Test
	public void test3() {
		TaskList tl2 = TaskDemo.generateRandomList(1000000);
		TaskDemo.reorderTasks(tl2);
		assertTrue(tl2.isOrdered());
	}
	
	@Test
	public void test4() {
		for(int i = 0; i < 100; i++) {
			TaskList tl2 = TaskDemo.generateRandomList(10000);
			TaskDemo.reorderTasks(tl2);
			assertTrue(tl2.isOrdered());
		}
	}

	
	@Test
	public void test5() {
		TaskList tl1 = new TaskList(100);
		tl1.add(new Task(Priority.LOW, "Task1"));
		tl1.add(new Task(Priority.LOW, "Task2"));
		tl1.add(new Task(Priority.LOW, "Task3"));
		tl1.add(new Task(Priority.LOW, "Task4"));
		tl1.add(new Task(Priority.MEDIUM, "Task5"));
			
		TaskDemo.reorderTasks(tl1);

		assertTrue(tl1.isOrdered());
	}
	
	@Test
	public void test6() {
		TaskList tl1 = new TaskList(100);
		tl1.add(new Task(Priority.HIGH, "Task1"));
		tl1.add(new Task(Priority.MEDIUM, "Task2"));
		tl1.add(new Task(Priority.MEDIUM, "Task3"));
		tl1.add(new Task(Priority.HIGH, "Task4"));
		tl1.add(new Task(Priority.HIGH, "Task5"));
			
		TaskDemo.reorderTasks(tl1);

		assertTrue(tl1.isOrdered());
	}

	
	@Test
	public void testRuntime() {
		double time10mio = TaskDemo.runtimeMS(10000000);
		assertTrue(time10mio <= 5000);
	}
		

	
}
