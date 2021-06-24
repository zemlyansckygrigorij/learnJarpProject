package com.example.demo.service.converter;

import com.example.demo.entity.Course;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ConverterListCoursesToXml {
    private List<Course> courses = new ArrayList<>();

    public ConverterListCoursesToXml(List<Course> courses) {
        this.courses = courses;
    }
    public void convert(String path){
       try{
           DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
           Document doc = docBuilder.newDocument();
           Element root = doc.createElement("courses");
           doc.appendChild(root);
           for(int i = 0;i< courses.size();i++){
               Course course = courses.get(i);

               Element courseEl = doc.createElement("course");
               root.appendChild(courseEl);

               Element id = doc.createElement("id");
               id.appendChild(doc.createTextNode(String.valueOf(course.getId())));
               courseEl.appendChild(id);

               Element name = doc.createElement("name");
               name.appendChild(doc.createTextNode(course.getName()));
               courseEl.appendChild(name);

               Element cost = doc.createElement("cost");
               cost.appendChild(doc.createTextNode(String.valueOf(course.getCost())));
               courseEl.appendChild(cost);

               Element duration = doc.createElement("duration");
               duration.appendChild(doc.createTextNode(String.valueOf(course.getDuration())));
               courseEl.appendChild(duration);
           }
           TransformerFactory transformerFactory = TransformerFactory.newInstance();
           Transformer transformer = transformerFactory.newTransformer();
           DOMSource source = new DOMSource(doc);
           StreamResult result = new StreamResult(new File(path));
           transformer.transform(source, result);
       } catch (ParserConfigurationException | TransformerConfigurationException e) {
           e.printStackTrace();
       } catch (TransformerException e) {
           e.printStackTrace();
       }
    }
}
