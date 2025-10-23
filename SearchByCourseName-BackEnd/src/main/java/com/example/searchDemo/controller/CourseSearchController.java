package com.example.searchDemo.controller;

import com.example.searchDemo.model.CourseSearchEntity;
import com.example.searchDemo.service.CourseSearchInputService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses") // ✅ Renamed base path for clarity
@CrossOrigin(origins = "http://localhost:5173")
public class CourseSearchController {

    private static final Logger logger = LoggerFactory.getLogger(CourseSearchController.class);

    @Autowired
    private CourseSearchInputService courseSearchInputService;

    @GetMapping("/all")
    public ResponseEntity<List<CourseSearchEntity>> getAllCourses() {
        logger.info("Fetching all available courses...");

        List<CourseSearchEntity> courses = courseSearchInputService.getAllSearchInput();

        logger.info("Total courses found: {}", courses.size());
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/search")
    public ResponseEntity<List<CourseSearchEntity>> searchCourses(@RequestParam String query) {
        logger.info("Search request received for keyword: '{}'", query);

        List<CourseSearchEntity> matchedCourses = courseSearchInputService.searchCourses(query);

        if (matchedCourses.isEmpty()) {
            logger.warn("No courses found for keyword: '{}'", query);
        } else {
            logger.info("Courses found for keyword '{}': {}", query, matchedCourses.size());
        }

        return ResponseEntity.ok(matchedCourses);
    }
}
