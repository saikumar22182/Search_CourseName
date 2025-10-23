import React, { useState, useEffect } from "react";
import "../styles/theme.css";

const SearchBar = () => {
  const [query, setQuery] = useState("");
  const [suggestions, setSuggestions] = useState([]);
  const [selectedCourse, setSelectedCourse] = useState(null);
  const [courseFound, setCourseFound] = useState(true);

  useEffect(() => {
    if (query.trim() === "") {
      setSuggestions([]);
      return;
    }

    const fetchCourses = async () => {
      try {
        const res = await fetch(`http://localhost:8080/api/courses/search?query=${query}`);
        const data = await res.json();
        setSuggestions(data);
        setCourseFound(data.length > 0);
      } catch (err) {
        console.error("Error fetching courses:", err);
        setCourseFound(false);
      }
    };

    const delay = setTimeout(fetchCourses, 300);
    return () => clearTimeout(delay);
  }, [query]);

  const handleSelect = (course) => {
    setSelectedCourse(course.courseName);
    setQuery(course.courseName);
    setSuggestions([]);
    setCourseFound(true);
  };

  return (
    <div className="container">
      <h2>🔍 Search Your Course</h2>

      <input
        type="text"
        placeholder="Start typing a course name..."
        value={query}
        onChange={(e) => {
          setQuery(e.target.value);
          setSelectedCourse(null);
        }}
      />

      {suggestions.length > 0 && (
        <ul className="suggestions">
          {suggestions.map((course) => (
            <li key={course.courseId} onClick={() => handleSelect(course)}>
              {course.courseName}
            </li>
          ))}
        </ul>
      )}

      {query && !courseFound && (
        <div className="result-message error">
          No courses found matching "{query}"
        </div>
      )}

      {selectedCourse && courseFound && (
        <div className="result-message success">
          <strong>{selectedCourse}</strong> was found!
        </div>
      )}
    </div>
  );
};

export default SearchBar;
