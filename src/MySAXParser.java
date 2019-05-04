import java.io.IOException;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class MySAXParser {

    public static void main(String[] args) {
        try {
            XMLReader reader  = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new DefaultHandler() {
                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    System.out.print("<" + localName + ">");
                }
                public void endElement(String uri, String localName, String qName) {
                    System.out.println("</" + localName + ">");
                }
            });
            try {
                reader.parse("ea31.xml");
            } catch(IOException e) {
                System.err.println(e.getMessage());
            }
        } catch (SAXException e){
            System.err.println(e.getMessage());
        }
    }
}
