package com.example.demo.service.converter;

import com.example.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CoverterTeacherXMLTest {
    @Autowired
    CoverterTeacherXML converter;
    @Value("${spring.out.teacher}")
    private String path;
    @Test
    public void makeTest(){
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setQualification("high");
        teacher.setDateBirth(new Date());
        teacher.setAddress("tehas");
        teacher.setFirstName("jhon");
        teacher.setSecondName("maison");
        teacher.setLastName("deison");

        try {
            converter.marshal(teacher,path);
            Teacher teacherOut = converter.unmarshall(path);
            assertEquals(teacher,teacherOut);
            Files.deleteIfExists( Paths.get(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}