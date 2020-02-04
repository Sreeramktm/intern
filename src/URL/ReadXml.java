package URL;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXml {
    public static void main(String[] args) {
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();//xml document to dom object tree
        DocumentBuilder dbuilder;
        try {
            dbuilder = dbfactory.newDocumentBuilder();
            Document doc = dbuilder.parse(new File("C:\\Users\\sreeram-pt3552\\Desktop\\employee.xml"));
            doc.getDocumentElement().normalize();
            System.out.println("root element is " + doc.getDocumentElement().getNodeName());
            NodeList node = doc.getElementsByTagName("employee");
            List<EmployeeData> employeeDataList = new ArrayList<>();
            try{
            for (int i = 0; i < node.getLength(); i++) {
                employeeDataList.add(getEmployee(node.item(i)));
            }}
            catch (NullPointerException e){
                System.out.println("Exception");
            }
            for (EmployeeData emp : employeeDataList) {
                System.out.println(emp.toString());}
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static EmployeeData getEmployee(Node node) {
        Element element=null;
        EmployeeData emp=null;
        try{
        emp = new EmployeeData();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            element = (Element) node;
            emp.setId(Integer.parseInt(getTagValue("id", element)));
            emp.setName(getTagValue("name", element));
            emp.setAge(Integer.parseInt(getTagValue("age", element)));
            emp.setDesignation(getTagValue("Designation", element));
            emp.setDept(getTagValue("dept", element));
            emp.setReportingto(getTagValue("reportingto", element));
        }
        }
        catch (NullPointerException e){System.out.println("Exception");}
        return emp;
    }

    private static String getTagValue(String tag, Element element) {
        Node node = null;
        try{
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        node = nodeList.item(0);}
        catch (NullPointerException e){System.out.println("Exception");}
        return node.getNodeValue();
    }
}
