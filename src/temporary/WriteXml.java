package temporary;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class WriteXml {
        public static void main(String argv[]) {
            ExampleLogger log=new ExampleLogger(1,"Sree",21,"mdm","trainee");
            try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.newDocument();
                Element rootElement = doc.createElement("company");
                doc.appendChild(rootElement);
                Element staff = doc.createElement("Staff");
                rootElement.appendChild(staff);
                Attr attr = doc.createAttribute("id");
                attr.setValue("1");
                staff.setAttributeNode(attr);
                Element classobj=doc.createElement("class");
                classobj.appendChild(doc.createTextNode(log.toString()));
                staff.appendChild(classobj);
                Element firstname = doc.createElement("firstname");
                firstname.appendChild(doc.createTextNode("Sreeram"));
                staff.appendChild(firstname);
                Element lastname = doc.createElement("lastname");
                lastname.appendChild(doc.createTextNode("KTM"));
                staff.appendChild(lastname);
                Element nickname = doc.createElement("nickname");
                nickname.appendChild(doc.createTextNode("Sree"));
                staff.appendChild(nickname);
                Element salary = doc.createElement("salary");
                salary.appendChild(doc.createTextNode("100000"));
                staff.appendChild(salary);
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("fileWrite.xml"));
                transformer.transform(source, result);

                System.out.println("File saved!");

            } catch (ParserConfigurationException pce) {
                pce.printStackTrace();
            } catch (TransformerException tfe) {
                tfe.printStackTrace();
            }
        }
    }


