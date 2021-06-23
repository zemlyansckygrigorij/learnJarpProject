package com.example.demo.repository;


import com.example.demo.entity.Gender;
import com.example.demo.entity.Student;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;



@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {
    @Autowired
    private StudentRepository repository;
    @Test
    public void makeTest(){
        long countFirst = repository.count();
        Assert.assertEquals("beforeInsert",1, countFirst);

        Student student = new Student();
        student.setAddress("tehas");
        student.setDateBirthday(new Date());
        student.setFirstName("jheck");
        student.setSecondName("maison");
        student.setLastName("stehan");
        student.setGender(Gender.man);
        student.setMarriage(false);
        repository.save(student);

        long countSecond = repository.count();
        Assert.assertEquals("afterInsert",2, countSecond);
    }
}