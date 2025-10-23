package com.example.searchDemo.service;

import com.example.searchDemo.model.CourseSearchEntity;

import java.util.List;

public interface CourseSearchInputService {

//    fetching all the cities
    public List<CourseSearchEntity> getAllSearchInput();

//    searching city names dynamically for search suggestions
    List<CourseSearchEntity> searchCourses(String keyword);
}
