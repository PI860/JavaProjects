package rl.prog2.demos.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class TelegramDemo {

	static class Telegramm {
		String pri;
		String an;
		String von;
		String betrifft;
		String grafik;
		String nachricht;

		public String toString() {
			return "Telegramm(" + pri + ", " + an + ", " + von + ", " + betrifft + ", \"" + nachricht + "\")";
		}
	}

	/**
	 * Reads a telegram from an xml file.
	 * 
	 * @param file
	 *            source definition
	 * @return the loaded telegram
	 * @throws Exception
	 *             if file could not be loaded correctly.
	 */
	public static Telegramm loadTelegramm(File file) throws Exception {
		Telegramm result = null;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setValidating(true);
			// factory.setNamespaceAware(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			builder.setEntityResolver(new MyEntityResolver());
			builder.setErrorHandler(new MyErrorHandler());
			Document doc = builder.parse(file);
			Node node = doc.getElementsByTagName("telegramm").item(0);

			result = new Telegramm();

			Node att = node.getAttributes().getNamedItem("pri");
			if (att != null)
				result.pri = att.getNodeValue();

			node = doc.getElementsByTagName("von").item(0);
			result.von = node.getTextContent();
			node = doc.getElementsByTagName("an").item(0);
			result.an = node.getTextContent();
			node = doc.getElementsByTagName("betrifft").item(0);
			result.betrifft = node.getTextContent();
			node = doc.getElementsByTagName("nachricht").item(0);
			result.nachricht = node.getTextContent();

			// TransformerFactory tFactory = TransformerFactory.newInstance();
			// Transformer transformer = tFactory.newTransformer();
			// DOMSource source = new DOMSource(node);
			// StringWriter writer = new StringWriter();
			// StreamResult resultStream = new StreamResult(writer);
			// transformer.transform(source, resultStream);
			// result.nachricht = writer.toString();

		} catch (Exception e) {
			Exception pe = new Exception("Loading telegram " + file + " failed.", e);
			throw pe;
		}
		return result;
	}

	/**
	 * Writes a telegram to an xml file.
	 * 
	 * @throws Exception if something went wrong...
	 *
	 */
	public static void saveTelegramm(File file, Telegramm telegramm) throws Exception {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			// factory.setValidating(true);
			// factory.setNamespaceAware(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			Element root = doc.createElement("telegram");
			doc.appendChild(root);
			root.setAttribute("pri", telegramm.pri);

			Element node = doc.createElement("von");
			root.appendChild(node);
			node.setTextContent(telegramm.von);

			node = doc.createElement("an");
			root.appendChild(node);
			node.setTextContent(telegramm.an);

			node = doc.createElement("betrifft");
			root.appendChild(node);
			node.setTextContent(telegramm.betrifft);

			node = doc.createElement("nachricht");
			root.appendChild(node);
			node.setTextContent(telegramm.nachricht);

			// exNode.appendChild(newNode);
			// }
			// if (!exercise.getSolution().isEmpty()) {
			// newNode = doc.createElement("solution");
			// newNode.setTextContent(exercise.getSolution());
			// exNode.appendChild(newNode);
			// }
			// }
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "telegramm.dtd");
			DOMSource source = new DOMSource(doc);
			// if (file.exists()) file.delete();
			StreamResult resultStream = new StreamResult(file);
			transformer.transform(source, resultStream);
		} catch (Exception e) {
			Exception pe = new Exception("Writing telegram to file " + file + " failed.", e);
			throw pe;
		}
	}

	// /**
	// * Creates a HTML representation for a given XML file.
	// *
	// * @param xmlFile
	// * Source file containing exercise set data.
	// * @param htmlFile
	// * Destination file.
	// * @param withSolutions
	// * Controls whether solutions are also printed out.
	// * @throws PersistenceException
	// */
	// public void transformExerciseSetToHTML(File xmlFile, File htmlFile,
	// boolean withSolutions) throws PersistenceException {
	// try {
	// String xsl = (withSolutions) ? "exercise-set-with-solutions.xsl"
	// : "exercise-set.xsl";
	// StreamSource stylesheet = new StreamSource(new FileInputStream(
	// new File(DTD_PATH, xsl)));
	// StreamSource src = new StreamSource(new FileInputStream(xmlFile));
	// src.setSystemId(DTD_PATH);
	// StreamResult result = new StreamResult(htmlFile);
	// TransformerFactory factory = TransformerFactory.newInstance();
	// Transformer t = factory.newTransformer(stylesheet);
	// t.transform(src, result);
	// } catch (Exception e) {
	// PersistenceException pe = new PersistenceException(
	// "Generation of the HTML file " + htmlFile + " failed.", e);
	// throw pe;
	// }
	// }

	/**
	 * Helps the XML parser to find locally stored DTDs.
	 * 
	 * @author R. Lunde
	 */
	public static class MyEntityResolver implements EntityResolver {
		public InputSource resolveEntity(String publicId, String systemId) throws FileNotFoundException {
			if (systemId.contains(".dtd")) {
				String dtdPath = "src/rl/prog2/demos/xml";
				// System.out.println("publicId=" + publicId + " systemId=" +
				// systemId);
				File file = new File(dtdPath, systemId.substring(systemId.lastIndexOf('/')));
				return new InputSource(new FileInputStream(file));
			} else {
				// System.out.println("Other tag found");
				return null;
			}
		}
	}

	/**
	 * Simple handler for XML parser exceptions.
	 * 
	 * @author R. Lunde
	 */
	private static class MyErrorHandler implements org.xml.sax.ErrorHandler {
		public void warning(SAXParseException ex) {
			System.out.println("Warning: " + ex.getMessage() + " " + ex);
		}

		public void error(SAXParseException ex) throws SAXException {
			throw ex;
		}

		public void fatalError(SAXParseException ex) throws SAXException {
			throw ex;
		}
	}

	public static void main(String[] args) {
		try {
			Telegramm tele = loadTelegramm(new File("src/rl/prog2/demos/xml/Telegramm.xml"));
			System.out.print(tele);
			saveTelegramm(new File("src/rl/prog2/demos/xml/Telegramm1.xml"), tele);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// }
	}

}
