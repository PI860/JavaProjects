package ALGO.pp.aufgabenblaetter.blatt06;

//JUnit 5 (Jupiter)

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JuTestDocumentSort {

	@Test
	public void testSort_1() {
		Document[] list = {
				new Document("docE", "59430253"),
				new Document("docC", "37302332"),
				new Document("docF", "59430253"),
				new Document("docB", "10002823"),
				new Document("docI", "93728599"),
				new Document("docA", "09372815"),
				new Document("docG", "77656973"),
				new Document("docH", "89372885"),
				new Document("docD", "37892845"),
		};
	
		Document.documentSort(list);

		assertEquals("id 09372815: docA", list[0].toString());
		assertEquals("id 10002823: docB", list[1].toString());
		assertEquals("id 37302332: docC", list[2].toString());
		assertEquals("id 37892845: docD", list[3].toString());
		assertEquals("id 59430253: docE", list[4].toString());
		assertEquals("id 59430253: docF", list[5].toString());
		assertEquals("id 77656973: docG", list[6].toString());
		assertEquals("id 89372885: docH", list[7].toString());
		assertEquals("id 93728599: docI", list[8].toString());	
	}

	
	@Test
	public void testSort_2() {
		Document[] list = Document.generateDocumentList(1000);
		Document.documentSort(list);
		
		// compare all adjacent values if they are ordered correctly
		System.out.println(list[0]);		
		for (int i = 0; i < list.length-1; i++) {
			System.out.println(list[i+1]);

			int res = list[i].getId().compareTo(list[i+1].getId());
			assertTrue(res <= 0);
			
		}
	}

	@Test
	public void testSort_3() {
		Document[] list = Document.generateDocumentList(100);
		Document[] list2 = list.clone();
		
		Document.documentSort(list);
		Arrays.sort(list2);
		
		
		// compare with result of Arrays.sort()
		for (int i = 0; i < list.length; i++) {
			assertEquals(list2[i], list[i]);
		}
	}

	
	
}
