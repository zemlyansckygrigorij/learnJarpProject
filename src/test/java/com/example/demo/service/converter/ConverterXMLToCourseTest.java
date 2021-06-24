package com.example.demo.service.converter;

import com.example.demo.entity.Course;


import org.springframework.beans.factory.annotation.Value;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
class ConverterXMLToCourseTest {
    @Value("${spring.dir.courses}")
    private String parth;


    @Test
    public void makeTest(){

        ConverterXMLToCourse converter = new ConverterXMLToCourse(parth);
        List<Course> courses = converter.getListCourses() ;
        assertEquals(4,courses.size());
    }
}