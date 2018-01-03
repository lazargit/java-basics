package application;

import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import javafx.scene.control.TreeItem;

public class CDTreeCreator {
//	<?xml version="1.0" encoding="UTF-8"?>
//	<CATALOG>
	//	<CD>
		//	<TITLE>Empire Burlesque</TITLE>
		//	<ARTIST>Bob Dylan</ARTIST>
		//	<COUNTRY>USA</COUNTRY>
		//	<COMPANY>Columbia</COMPANY>
		//	<PRICE>10.90</PRICE>
		//	<YEAR>1985</YEAR>
		
	/**
	 * erzeugt einen Tree und gibt den Root-Konten zurück (der Root-Koten beinhaltet alle andere Kind-Knoten)
	 * @param documentPath
	 * @return
	 */
	public static TreeItem<String> createTree(String documentPath) {
		TreeItem<String> catalogItem = new TreeItem<>();
		// hier Tree mit Hilfe von Jdom erzeugen -> SaxBuilder-> XML lesen
		SAXBuilder builder = new SAXBuilder();
		
		try {
			Document doc = builder.build(documentPath);
			Element catalogElement =  doc.getRootElement();
			catalogItem.setValue(catalogElement.getName());// CATALOG
			
			List<Element> cdElemente = catalogElement.getChildren();// <cd>...</cd><cd>...</cd><cd>...</cd>
			for (Element cdElement : cdElemente) {
				TreeItem<String> cdItem = new TreeItem<>();
				cdItem.setValue(cdElement.getChildText("TITLE"));// Text-Element vom Child mit dem namen TITLE
				List<Element> cdDataElemente  = cdElement.getChildren();// TITLE, ARTIST,...
				for (Element cdDataElement : cdDataElemente) {
					TreeItem<String> cdDataItem = new TreeItem<>();
					
					cdDataItem.setValue(cdDataElement.getName()+": "+cdDataElement.getTextTrim());// ARTIST: Bob Dylan
					cdItem.getChildren().add(cdDataItem);
					
				}
				catalogItem.getChildren().add(cdItem);
			}
			
			
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
	
		return catalogItem;
	}

}
