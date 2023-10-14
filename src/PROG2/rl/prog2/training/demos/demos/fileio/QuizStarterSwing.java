//package rl.prog2.demos.fileio;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Creates a {@link QuizGUISwing}, equips it with a default card set about file i/o
// * and a persistence manager, which supports serialized objects and CSV file
// * format, and starts it.
// *
// * @author Ruediger Lunde
// *
// */
//public class QuizStarterSwing {
//
//	/** Starts the quiz. */
//	public static void main(String[] args) {
//		QuizGUISwing quiz = new QuizGUISwing();
//		quiz.setCards(createDefaultCards());
//		quiz.setPersistenceManager(new DefaultPersistenceManager());
//		quiz.start();
//	}
//
//	/** Creates some cards about file i/o. */
//	private static List<QuizCard> createDefaultCards() {
//		List<QuizCard> cards = new ArrayList<QuizCard>();
//		cards.add(new QuizCard("Welche zwei Arten von Strömen gibt es in Java?",
//				"Anschlussströme und Verkettungsströme."));
//		cards.add(new QuizCard(
//				"Welche Ströme werden benötigt, um Objekte zu serialisieren?",
//				"Ein ObjectOutputStream sollte mit einem FileOutputStream verkettet werden."));
//		cards.add(new QuizCard(
//				"Zu welcher Art von Strömen gehört der FileOutputStream?",
//				"Der FileOutputStream gehört zu den Anschlussströmen."));
//		cards.add(new QuizCard(
//				"Welche Ströme werden benötigt, um serialisierte Objekte einzulesen?",
//				"Ein ObjectInputStream sollte mit einem FileInputStream verkettet werden."));
//		cards.add(new QuizCard(
//				"Welche Methode erledigt das serialisieren von Objekten?",
//				"Die ObjectOutputStream-Methode writeObject."));
//		cards.add(new QuizCard(
//				"Welche Ströme werden benötigt, um Textdateien zu lesen und zu schreiben?",
//				"FileReader und FileWriter."));
//		cards.add(new QuizCard(
//				"Wie lässt sich das Lesen über einen FileReader beschleunigen?",
//				"Durch Verketten eines BufferedReader mit dem FileReader."));
//		cards.add(new QuizCard(
//				"Wie lässt sich das Schreiben über einen FileWriter beschleunigen?",
//				"Durch Verketten eines BufferedWriter mit dem FileWriter."));
//		return cards;
//	}
//
//	/**
//	 * Demonstrates how to load and save objects using (a) object serialization
//	 * and (b) a simple CSV text file format.
//	 *
//	 * @author Ruediger Lunde
//	 */
//	public static class DefaultPersistenceManager implements
//			QuizPersistenceManager {
//
//		static final String SER = "ser";
//		static final String CSV = "csv";
//
//		public String[] getSupportedFileExtensions() {
//			return new String[] { SER, CSV };
//		}
//
//		public String[] getFileFormatDescriptions() {
//			return new String[] { "Serialized Objects",
//					"Comma-Separated Values" };
//		}
//
//		public List<QuizCard> loadCards(File file) throws Exception {
//			String fileName = file.getName();
//			if (fileName.endsWith(SER))
//				return loadFromSerFile(file);
//			else if (fileName.endsWith(CSV))
//				return loadFromCsvFile(file);
//			else
//				throw new IllegalStateException("File format not supported.");
//		}
//
//		public void saveCards(File file, List<QuizCard> cards) throws Exception {
//			String fileName = file.getName();
//			if (fileName.endsWith(SER))
//				saveToSerFile(file, cards);
//			else if (fileName.endsWith(CSV))
//				saveToCsvFile(file, cards);
//			else
//				throw new IllegalStateException("File format not supported.");
//		}
//
//		@SuppressWarnings("unchecked")
//		public static List<QuizCard> loadFromSerFile(File file)
//				throws IOException, ClassNotFoundException {
//			// System.out.println("loading...");
//			FileInputStream fis = new FileInputStream(file);
//			ObjectInputStream ois = new ObjectInputStream(fis);
//			List<QuizCard> result = (List<QuizCard>) ois.readObject();
//			ois.close();
//			return result;
//		}
//
//		public static void saveToSerFile(File file, List<QuizCard> cards)
//				throws IOException {
//			// System.out.println("saving...");
//			FileOutputStream fos = new FileOutputStream(file);
//			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			oos.writeObject(cards);
//			oos.close();
//		}
//
//		public static List<QuizCard> loadFromCsvFile(File file)
//				throws IOException {
//			// System.out.println("importing...");
//			List<QuizCard> result = new ArrayList<QuizCard>();
//			FileReader freader = new FileReader(file);
//			BufferedReader breader = new BufferedReader(freader);
//			String line;
//			while ((line = breader.readLine()) != null) {
//				String[] token = line.split(";");
//				result.add(new QuizCard(token[0], token[1]));
//			}
//			breader.close();
//			return result;
//		}
//
//		public static void saveToCsvFile(File file, List<QuizCard> cards)
//				throws IOException {
//			// System.out.println("exporting...");
//			FileWriter fwriter = new FileWriter(file);
//			BufferedWriter bwriter = new BufferedWriter(fwriter);
//			for (QuizCard card : cards) {
//				bwriter.write(prepareForCsv(card.getQuestion()) + ";");
//				bwriter.write(prepareForCsv(card.getAnswer()) + "\n");
//			}
//			bwriter.close();
//		}
//
//		private static String prepareForCsv(String text) {
//			String result = text.replace(';', ',');
//			result = result.replace("\n", " ");
//			return result;
//		}
//	}
//}
