package com.allen;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * Created by Allen on 2017-08-09.
 */
public class Main {
    private static String getOSValue() {
        if (PlatformUtil.isMac()) {
            return "/Users/Allen/Projects/QueueManager/src/chromedriver/chromedriver";
        }
        if (PlatformUtil.isWin7OrLater()) {
            return "C:\\Users\\I860745\\Documents\\Projects\\QueueManager\\src\\chromedriver\\Windows\\chromedriver.exe";
        }
        return null;
    }

    public static Document loadXMLFromString(String xml) throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        return builder.parse(is);
    }

    public static void main(String[] args) {
        String key = "webdriver.chrome.driver";
        String value = getOSValue();
        String url = "https://support.wdf.sap.corp/sap/bc/devdb/saved_search?sap-client=001&search_id=0090FAE68C221ED78F84917FE2FBA0CB&format=json";

        System.setProperty(key, value);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        String pageSource = driver.getPageSource();
        int beginIndex = pageSource.indexOf('{') + 9;
        int endIndex = pageSource.indexOf('}');

        String JSONsource = pageSource.substring(beginIndex, endIndex);
        System.out.println(pageSource);

/*
        try {

            // read XML from File
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document docFile = builder.parse(new File("C:\\Users\\I860745\\Documents\\Projects\\QueueManager_SAP\\sample.xml"));

//            -------------------------------------------------------------------------------------------
            // save to XML file
            // https://stackoverflow.com/questions/4561734/how-to-save-parsed-and-changed-dom-document-in-xml-file
//            Transformer transformer = TransformerFactory.newInstance().newTransformer();
//            Result output = new StreamResult(new File("output.xml"));
//            Source input = new DOMSource(doc);
//
//            transformer.transform(input, output);

            Element rootElement = doc.getDocumentElement();
            System.out.println(rootElement.getTagName());


        } catch (Exception e) {
            e.printStackTrace();
        }


*/
        driver.close();
    }

    public static void deletePerson(Document doc, String ID) {
        // <person>
        NodeList nodes = doc.getElementsByTagName("person");

        for (int i = 0; i < nodes.getLength(); i++) {
            Element person = (Element)nodes.item(i);
            // <name>
            Element name = (Element)person.getElementsByTagName("OBJECT_ID").item(0);
            String pName = name.getTextContent();
            if (pName.equals(ID)) {
                person.getParentNode().removeChild(person);
            }
        }
    }

    public static void printXML(Document doc) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        StreamResult result = new StreamResult(new StringWriter());
        DOMSource source = new DOMSource(doc);
        transformer.transform(source, result);

        String xmlString = result.getWriter().toString();
        System.out.println(xmlString);
    }
}
