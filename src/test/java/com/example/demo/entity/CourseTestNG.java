package com.example.demo.entity;


import org.testng.annotations.Test;
import org.testng.Assert;

class CourseTestNG {
    @Test
    public void makeTest() throws Exception {
        Course course = new Course();
        course.setId(1);
        course.setCost(2.3);
        course.setDuration(12);
        course.setName("Math");
        Assert.assertEquals(course.getId(),1);
        Assert.assertEquals(course.getCost(),2.3);
        Assert.assertEquals(course.getName(),"Math");
        Assert.assertEquals(course.getDuration(),12);

        Assert.assertNotEquals(course.getId(),12);
        Assert.assertNotEquals(course.getCost(),2.1);
        Assert.assertNotEquals(course.getName(),"Math2");
        Assert.assertNotEquals(course.getDuration(),121);
    }
}