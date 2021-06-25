package com.example.demo.service.converter;

import com.example.demo.entity.Teacher;
import com.example.demo.entity.TeacherXML;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class CoverterTeacherXML {
    public void marshal(Teacher teacher, String path) throws JAXBException, IOException {

        TeacherXML tXML = new TeacherXML(teacher);
        JAXBContext context = JAXBContext.newInstance(TeacherXML.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(tXML, new File(path));
    }
    public Teacher unmarshall( String path) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(TeacherXML.class);
        TeacherXML tXML =  (TeacherXML) context.createUnmarshaller()
                .unmarshal(new FileReader(path));
        return new Teacher(tXML);
    }
}
