package inv;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class Store implements StoreCapable{
	
	private static String FILENAME = "product.xml";

	private void saveToXml(Product product) 
	{
		File xmlFile = new File(FILENAME);
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc;
			Element rootElement;
			
			if (xmlFile.exists()) {
				doc = dBuilder.parse(xmlFile);
				rootElement = doc.getDocumentElement();
			} else {
				doc = dBuilder.newDocument();
				rootElement = doc.createElement("Products");
				doc.appendChild(rootElement);
			}

			// root element

			// element
			Element name = doc.createElement("Product");
			rootElement.appendChild(name);

			// setting attribute to element
			Attr attr = doc.createAttribute("name");
			attr.setValue(product.getName());
			name.setAttributeNode(attr);
			Attr attr2 = doc.createAttribute("price");
			attr2.setValue(product.getPrice().toString());
			name.setAttributeNode(attr2);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(FILENAME));
			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected Product createProduct(String type, String name, int price, int size)
	{
		if (type == "CD") {
			CDProduct CD = new CDProduct(name, price, size);
			return CD;

		} else if(type == "Book"){
			BookProduct Book = new BookProduct(name, price, size);
			return Book;
		}
		else throw new RuntimeException("This type of pruduct is not available!");
		
	}
	
	public ArrayList<Product> loadProducts()
	{
		ArrayList<Product> products = new ArrayList<>();
        try
        {
            File file = new File(FILENAME);
            
            DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuild = dBF.newDocumentBuilder();
            Document doc = dBuild.parse(file);
            doc.getDocumentElement().normalize();
            
            NodeList nodes = doc.getElementsByTagName("Product");
            
            for(int i = 0; i<nodes.getLength(); i++)
            {
                Node node = nodes.item(i);
                String name = ((Element)node).getAttribute("name");
                String priceStr = ((Element)node).getAttribute("price");
                int price = Integer.parseInt(priceStr);
                Product product = createProduct("CD", name, price, 0 );
                products.add(product);
            }
            return products;
        }
        catch(Exception e)
        {
            System.out.println("File not found");
        }
        return null;
	}
	
	public void store(Product product)
	{
		saveToXml(product);
		storeProduct(product);	  
	}
	
	protected  void storeProduct(Product product){
		
	}
}
