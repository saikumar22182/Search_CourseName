# search-coursename

A simple React-based frontend application for searching courses by name.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Development](#development)
- [API Endpoints](#api-endpoints)
- [Project Structure](#project-structure)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## Overview

`search-coursename` is a user-friendly frontend application built with React and Vite. The project allows users to search for courses by name by interacting with a backend API that returns matching course suggestions.

## Features

- **Real-Time Search:** Provides live course suggestions as you type.
- **Debouncing:** Minimizes API calls by waiting for user input.
- **Responsive UI:** Clean, modern interface for an improved user experience.
- **CORS Support:** Configured to work with a backend at `http://localhost:8080`.

## Prerequisites

- **Node.js:** Version 20.19+ or 22.12+ is required.
- **npm:** v11.6.2 or later.
- **Backend API:** An API to handle course search requests (expected endpoint: `/api/courses/search`).

## Installation

1. **Clone the repository:**

   ````bash
   git clone <repository-url>
   cd SearchByCourseName-FrontEnd
   ````

2. **Install dependencies:**

   ```bash
   npm install
   ```

3. **Start the development server:**

   ```bash
   npm run dev
   ```

4. **Access the application:**

   Open your browser and navigate to `http://localhost:5173`.

## Usage

1. Enter a course name or keyword in the search bar.
2. View real-time suggestions from the API.
3. Select a course from the dropdown or continue typing to refine results.

## Development

- The project is bootstrapped with [Vite](https://vitejs.dev/) for fast development.
- React Query is used for data fetching and state management.
- Axios is used for making API requests.

## API Endpoints

- **Search Courses:** `GET /api/courses/search?query={courseName}`

## Project Structure

```
search-coursename/
├── public/
│   └── vite.svg
├── src/
│   ├── components/
│   │   ├── CourseList.jsx
│   │   └── SearchBar.jsx
│   ├── hooks/
│   │   └── useDebounce.js
│   ├── App.jsx
│   ├── main.jsx
│   └── styles.css
├── .env
├── index.html
└── package.json
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Inspired by the need for efficient course search tools in educational platforms.
- Thanks to the contributors and the open-source community for their invaluable support.
