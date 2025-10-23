package com.example.searchDemo.repository;

import com.example.searchDemo.model.CourseSearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseSearchInputRepo extends JpaRepository<CourseSearchEntity, Integer> {

//    Custom query method for city search (used for auto-suggestions)
    List<CourseSearchEntity> findByCourseNameContainingIgnoreCase(String cityName);
}
