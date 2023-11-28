package ALGO.pp.aufgabenblaetter.blatt06;

import java.util.LinkedList;
import java.util.Random;

public class Document implements Comparable<Document> 
{
	private String id; //key = 8 digit document ID, leading zeros possible
	private String title; 
	
	public static final int ID_LENGTH = 8;
	
	public Document(String title, String id) {
		this.title = title;
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public String toString() {
		return "id " + id + ": " + title; 
	}
	
	/**Sort an array of document using radix sort.	 */
	public static void documentSort(Document[] dlist) {
		int maxLength = ID_LENGTH;

		for (int i = maxLength - 1; i >= 0; i--) {
			countingSort(dlist, i);
		}
	}

	private static void countingSort(Document[] dlist, int index) {
		final int radix = 10; // Decimal system

		// Initialize counting array
		LinkedList<Document>[] count = new LinkedList[radix];
		for (int i = 0; i < radix; i++) {
			count[i] = new LinkedList<>();
		}

		// Place elements in counting array
		for (Document document : dlist) {
			int digit = Character.getNumericValue(document.getId().charAt(index));
			count[digit].add(document);
		}

		// Collect elements from counting array
		int pos = 0;
		for (LinkedList<Document> bucket : count) {
			for (Document document : bucket) {
				dlist[pos++] = document;
			}
		}
	}
	
	@Override
	public int compareTo(Document other) {
		return id.compareTo(other.id);
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof Document) {	
			return id == ((Document)other).id;
		} else {
			return false;
		}
	}
	
	
	
	/** generates randomly an array containing the specified number of documents with random id numbers */
	public static Document[] generateDocumentList(int size) {
		Document[] list = new Document[size];
		
		Random rand = new Random();
		
		for (int i = 0; i < list.length; i++) {
			String title = "S_" + i;
			//generate random ID
			int did = rand.nextInt(90000000);
			did+=10000000;
			String matnrStr = Integer.toString(did);
			
			list[i] = new Document(title, matnrStr);
		}
		
		return list;
	}
	
	


	
}
