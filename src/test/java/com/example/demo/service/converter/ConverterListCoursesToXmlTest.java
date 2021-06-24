package com.example.demo.service.converter;

import com.example.demo.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConverterListCoursesToXmlTest {
    @Value("${spring.out.courses}")
    private String pathOut;
    @Value("${spring.dir.courses}")
    private String path;
    @Test
    public void makeTest(){
        ConverterXMLToCourse converter = new ConverterXMLToCourse(path);
        List<Course> courses = converter.getListCourses() ;

        ConverterListCoursesToXml converterToXml = new ConverterListCoursesToXml(courses);
        converterToXml.convert(pathOut);

        ConverterXMLToCourse converterOut = new ConverterXMLToCourse(pathOut);
        List<Course> coursesOut = converterOut.getListCourses() ;


        assertEquals(coursesOut.size(),courses.size());
        assertTrue(coursesOut.containsAll(courses));
    }
}