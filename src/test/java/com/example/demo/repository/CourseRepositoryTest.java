package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CourseRepositoryTest {
    @Autowired
    private CourseRepository repository;
    @Test
    public void makeTest(){
        long countFirst = repository.count();
        assertEquals(0, countFirst);

        Course course = new Course();
        course.setName("math");
        course.setCost(123);
        course.setDuration(12);
        repository.save(course);

        long countSecond = repository.count();
        assertEquals(1, countSecond);
    }
}