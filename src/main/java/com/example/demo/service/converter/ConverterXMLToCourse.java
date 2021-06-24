package com.example.demo.service.converter;

import com.example.demo.entity.Course;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ConverterXMLToCourse {

    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    private List<Course> listCourses = new ArrayList<>();
    public String getPath() {
        return path;
    }

    public List<Course> getListCourses() {
        try{
            File fXmlFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nCourse = doc.getElementsByTagName("course");

            for(int i =0;i<nCourse.getLength();i++){
                Course course = new Course();
                Node nNode = nCourse.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    course.setId( Double.valueOf(eElement.getElementsByTagName("id").item(0).getTextContent().trim()).intValue());
                    course.setName(eElement.getElementsByTagName("name").item(0).getTextContent().trim());
                    course.setCost(Double.valueOf(eElement.getElementsByTagName("cost").item(0).getTextContent().trim()).intValue());
                    course.setDuration(Integer.valueOf(eElement.getElementsByTagName("duration").item(0).getTextContent()));
                }
                listCourses.add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listCourses;
    }

    public ConverterXMLToCourse(String path) {
        this.path = path;
    }


}

