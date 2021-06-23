package com.example.demo.repository;

import com.example.demo.entity.Subject;
import com.example.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository repository;
    @Test
    public void makeTest(){
        long countFirst = repository.count();
        assertEquals(0, countFirst);

        Teacher teacher = new Teacher();
        teacher.setAddress("tenneccy");
        teacher.setFirstName("Alfred");
        teacher.setSecondName("derec");
        teacher.setLastName("maison");
        teacher.setBiography("description");
        teacher.setDateBirth(new Date());
        teacher.setQualification("high");
        repository.save(teacher);

        long countSecond = repository.count();
        assertEquals(1, countSecond);
    }
}