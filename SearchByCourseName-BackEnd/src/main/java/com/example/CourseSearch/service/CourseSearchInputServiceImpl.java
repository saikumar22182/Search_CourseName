package com.example.searchDemo.service;

import com.example.searchDemo.model.CourseSearchEntity;
import com.example.searchDemo.repository.CourseSearchInputRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSearchInputServiceImpl implements CourseSearchInputService {

    private static final Logger log = LoggerFactory.getLogger(CourseSearchInputServiceImpl.class);

    @Autowired
    CourseSearchInputRepo courseSearchInputRepo;

    @Override
    public List<CourseSearchEntity> getAllSearchInput() {
        List<CourseSearchEntity> searchInputEntityList = courseSearchInputRepo.findAll();
        System.out.println();

//        showing the searched data in console
        log.info("Showing search input cities: {}",searchInputEntityList);
        return searchInputEntityList;
    }

    @Override
    public List<CourseSearchEntity> searchCourses(String keyword) {
        List<CourseSearchEntity> byMatchedCityNameContainingIgnoreCase = courseSearchInputRepo.findByCourseNameContainingIgnoreCase(keyword);
        log.info("Auto-suggestion results for '{}': {}", keyword, byMatchedCityNameContainingIgnoreCase);
        return byMatchedCityNameContainingIgnoreCase;
    }
}
