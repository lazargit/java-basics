package xml;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class XMLReader {
	
	public static void  readXML(String filename){
		SAXBuilder builder = new SAXBuilder();
		try {
			Document  doc = builder.build(filename);
			Element menubarElement =  doc.getRootElement(); //<menubar
			System.out.println(menubarElement.getName());//<menubar
			List<Element> menuElemente =  menubarElement.getChildren();
			for (Element menuElement : menuElemente) {
				System.out.println(menuElement.getName());// <menu
				String attributvalue = menubarElement.getAttributeValue("name"); // name="..."
				//System.out.println(attributvalue);
				List<Element> menuitemElemente = menuElement.getChildren();
				for (Element menuitemElement : menuitemElemente) {
					String elementname = menuitemElement.getName();
					String itemText = menuitemElement.getTextTrim();// Open
					System.out.println(elementname+": " +itemText);
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		readXML("./menu.xml");
	}

}
