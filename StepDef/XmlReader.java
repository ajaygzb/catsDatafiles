package cats.selenium.bdd.stepdef;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlReader {
	private Document doc;
	private XPath xPath =  XPathFactory.newInstance().newXPath();
	
    
	/**
	 * Instantiates a new xml reader.
	 *
	 * @param xmlString the xml string
	 */
	public XmlReader(String xmlString) {
        doc =  convertStringToDocument(xmlString);
        
	}


	/**
	 * Instantiates a new xml reader.
	 *
	 * @param fileName the file name
	 */
	public XmlReader(File fileName) {
		try{
			String strFile = FileUtils.readFileToString(fileName,"UTF-8");
			doc = convertStringToDocument(strFile);	
			
		}catch (IOException e) {
            System.out.println("File not Found: " + e);    
        } 

	}

	/**
	 * Gets the node count.
	 *
	 * @param strXpath the str xpath
	 * @return the node count
	 * @throws XPathExpressionException the x path expression exception
	 */
	public String getNodeCount(String strXpath) throws XPathExpressionException {
		
        try {
    	    NodeList nodeList = (NodeList) xPath.compile(strXpath).evaluate(doc, XPathConstants.NODESET);
    	    return Integer.toString(nodeList.getLength());
        } catch (XPathExpressionException e) {
            e.printStackTrace();
            return null;
        }
        
    }
	
	
	public int getNodeCountInt(String strXpath) throws XPathExpressionException {
		
        
    	    NodeList nodeList = (NodeList) xPath.compile(strXpath).evaluate(doc, XPathConstants.NODESET);
    	    return nodeList.getLength();
        
    }
	
	/**
	 * Gets the node value.
	 *
	 * @param strXpath the str xpath
	 * @return the node value
	 * @throws XPathExpressionException the x path expression exception
	 */
	public List<String> getNodeValue(String strXpath)  {
	     List<String> values=new LinkedList<>();

	        try {
	        	 NodeList nodeList = (NodeList) xPath.compile(strXpath).evaluate(doc,XPathConstants.NODESET);
	        	 for(int i=0;i<nodeList.getLength();i++){
	    	    	 values.add(nodeList.item(i).getTextContent());
	    	     }
	        } catch (XPathExpressionException e) {
	        	values=null;
	            System.out.println("Exception due to : "+ e.getMessage());
	        }
	        return values;
	    }

	/**
	 * Gets the child count.
	 *
	 * @param strXpath the str xpath
	 * @return the child count
	 * @throws XPathExpressionException the x path expression exception
	 */
	public String getChildCount(String strXpath) throws XPathExpressionException {
		
        try {
        	NodeList nodeList = (NodeList) xPath.compile(strXpath).evaluate(doc, XPathConstants.NODESET);
        	int iChilCount = nodeList.item(0).getChildNodes().getLength();
        	return Integer.toString(iChilCount);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
            return null;
        }catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
		
    }
	
	/**
	 * Sets the node value.
	 *
	 * @param strXpath the str xpath
	 * @param nodeValue the node value
	 * @return the complete xml string
	 * @throws XPathExpressionException 
	 * @throws TransformerException 
	 */
	public String setNodeValue(String strXpath, String nodeValue) throws XPathExpressionException, TransformerException {
		
        	NodeList nodeList = (NodeList) xPath.compile(strXpath).evaluate(doc, XPathConstants.NODESET);
        	nodeList.item(0).setTextContent(nodeValue);
    	  	DOMSource domSource = new DOMSource(doc);
    	    StringWriter writer = new StringWriter();
    	    StreamResult result = new StreamResult(writer);
    	    TransformerFactory tf = TransformerFactory.newInstance();
    	    Transformer transformer = tf.newTransformer();
    	    transformer.transform(domSource, result);
    	    return writer.toString();
    }
	
    /**
     * Convert string to document.
     *
     * @param xmlStr the xml str
     * @return the document
     */
    public Document convertStringToDocument(String xmlStr) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

  //***********************Adding for testing to ignore namespace ******************    

        factory.setNamespaceAware(false);
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            
            Document doc = builder.parse(new InputSource(new StringReader(xmlStr)));
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public String convertDocumentToString() throws TransformerException{
    	TransformerFactory tF= TransformerFactory.newInstance(); 
		Transformer transformer=tF.newTransformer();
		DOMSource src=new DOMSource(this.doc);
		StringWriter writer=new StringWriter();
		StreamResult result = new StreamResult(writer);
		transformer.transform(src, result);
		return writer.toString();	
    }
    
    /**
     * 
     * @param xmlTagPath
     * @param xmlTagValue
     * @return
     */
    public String getXmlDataFromXmlPath(String xmlNodePath, String xmlNodeName) {


    	/*String var = "Tag Value not found";
    	try {
    		doc.getDocumentElement().normalize();
    		XPath xPath = XPathFactory.newInstance().newXPath();
    		String expression = xmlNodePath;
    		NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
    		Node nNode = nodeList.item(0);
    		Element eElement = (Element) nNode;
    		String nodevalue = eElement.getElementsByTagName(xmlNodeName).item(0).getTextContent();
    		return nodevalue;

    	}catch (XPathExpressionException e) {
			
    		return var+e.getMessage();
		}catch (NullPointerException e) {
			
    		return var+e.getMessage();
		}*/
    	
    	String tagvalue = "Tag not found";

        try {
        	 NodeList nodeList = (NodeList) xPath.compile(xmlNodePath+"/"+xmlNodeName).evaluate(doc,XPathConstants.NODESET);  
        	  tagvalue=nodeList.item(0).getTextContent();
        } catch (XPathExpressionException e) {
        	return tagvalue;
        }catch (NullPointerException e) {			
    		return tagvalue;
		}
        return tagvalue;


    }

    
    /**
     * 
     * @param xmlTagPath
     * @param xmlTagValue
     * @return
     * @throws TransformerException 
     */
    public String removeXmlDataFromXmlPath(String xmlNodePath) throws TransformerException {
    	
    	String tagvalue = "Tag not found";
    	tagvalue= convertDocumentToString();

        try {
        	 NodeList nodeList = (NodeList) xPath.compile(xmlNodePath).evaluate(doc,XPathConstants.NODESET);  
        	
        	 
        	 for (int i = nodeList.getLength() - 1; i >= 0; i--) 
        	    {
        		 //doc.removeChild(nodeList.item(i)) ;
        		 nodeList.item(i).getParentNode().removeChild(nodeList.item(i));
        	    }
        	 tagvalue= convertDocumentToString();
        	
        	 
        } catch (XPathExpressionException e) {
        	return tagvalue;
        }catch (NullPointerException e) {			
    		return tagvalue;
		}
        return tagvalue;


    }
    
    /**
     * 
     * @param strXpath
     * @param nodeValue
     * @return
     * @throws XPathExpressionException
     * @throws TransformerException
     */
    public String setNodeValueXml(String strXpath, String nodeValue) throws XPathExpressionException, TransformerException {
		
    	NodeList nodeList = (NodeList) xPath.compile(strXpath).evaluate(doc, XPathConstants.NODESET);
    	nodeList.item(0).setTextContent(nodeValue);
	  	DOMSource domSource = new DOMSource(doc);
	    StringWriter writer = new StringWriter();
	    StreamResult result = new StreamResult(writer);
	    TransformerFactory tf = TransformerFactory.newInstance();
	    Transformer transformer = tf.newTransformer();
	    transformer.transform(domSource, result);
	     writer.toString();
	     return convertDocumentToString();
}
    
	/**
	 * Gets the node value.
	 *
	 * @param strXpath the str xpath
	 * @return the node value
	 * @throws XPathExpressionException the x path expression exception
	 */
	public List<String> getNodeValueExt(String strXpath)  {
	     List<String> values=new LinkedList<>();
	        try {
	        	 NodeList nodeList = (NodeList) xPath.compile(strXpath).evaluate(doc,XPathConstants.NODESET);
	        	 for(int i=0;i<nodeList.getLength();i++){
	    	    	 values.add(nodeList.item(i).getTextContent());
	    	     }
	    	} catch (XPathExpressionException e) {
	    		return values;
	    	}
	        if(values.size()==0){
	        	values.add("Tag not found");
	        }
	    	return values;
	    	
	    }

	
//  String xpath = "//Diagram";
//  List<NodeList> nodes = (List<NodeList>) XmlUtil.getElements(document,
//          xpath);
//
//    for (int i = 0; i < ((NodeList) list).getLength(); i++) {
//        // Get Node
//        Node node = (Node) ((NodeList) list).item(i);
//                     
//            NodeList childList = node.getChildNodes();
//            // Look through all the children
//            for (int x = 0; x < childList.getLength(); x++) {
//                Node child = (Node) childList.item(x);
//
//                node.getParentNode().removeChild(child);
//         
//        }
//    }

    
    
    /**
     * 
     * @param xmlNodePath
     * @return
     * @throws TransformerException
     */
    public String addXmlDataFromXmlPath(String xmlNodePath) throws TransformerException {

    	String tagvalue = "Tag not found";
    	tagvalue= convertDocumentToString();
    	System.out.println(tagvalue);
    	try {
    		NodeList nodeList = (NodeList) xPath.compile(xmlNodePath).evaluate(doc,XPathConstants.NODESET);  
    		//Text a = doc.createTextNode("value");
    		Element p = doc.createElement("newNode");
    		
    		
    		tagvalue= convertDocumentToString();
    		System.out.println(tagvalue);

    	} catch (XPathExpressionException e) {
    		return tagvalue;
    	}catch (NullPointerException e) {			
    		return tagvalue;
    	}
    	return tagvalue;


    }

    
}
