package com.example.demo.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    @Test
    public void makeTest()  {
        Course course = new Course();
        course.setId(1);
        course.setCost(2.3);
        course.setDuration(12);
        course.setName("Math");
        assertEquals(course.getId(),1);
        assertEquals(course.getCost(),2.3);
        assertEquals(course.getName(),"Math");
        assertEquals(course.getDuration(),12);



        assertNotEquals(course.getId(),12);
        assertNotEquals(course.getCost(),2.1);
        assertNotEquals(course.getName(),"Math2");
        assertNotEquals(course.getDuration(),121);

        CourseTestNG courseTestNG = new CourseTestNG();
        try {
            courseTestNG.makeTest();
        }catch(Exception e){
            e.getStackTrace();
        }
    }
}