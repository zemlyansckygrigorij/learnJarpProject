package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    /*@Query("SELECT e FROM Course e WHERE e.name = :name")
    public Optional getCourseByName(@Param("name") String name);*/
}
