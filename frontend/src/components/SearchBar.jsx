import React, { useState } from "react";
import styles from "./SearchBar.module.css";
import SearchResult from "./SearchResult"; // Component to display search results

const SearchBar = () => {
  const [searchQuery, setSearchQuery] = useState(""); // State to track the user's search query
  const [searchResult, setSearchResult] = useState([]); // State to store search results
  const [emptyQuery, setEmptyQuery] = useState(true); // State to track if the search query is empty
  const [inputFocused, setInputFocused] = useState(false); // State to track if the input is focused

  // Function to handle input changes
  const handleInputChange = (event) => {
    const query = event.target.value;
    setSearchQuery(query); // Update the search query state
    if (query === "") {
      setEmptyQuery(true); // Mark query as empty if input is cleared
    } else {
      setEmptyQuery(false); // Mark query as non-empty
    }

    if (query.length < 2) {
      setSearchResult([]); // Clear results for queries shorter than 2 characters
      return;
    }

    fetchResults(query); // Fetch search results for valid queries
  };

  // Function to fetch search results from the backend
  const fetchResults = async (query) => {
    try {
      const response = await fetch(`https://api.lbeautysupplies.com/search/query?term=${query}`);
      if (!response.ok) {
        throw new Error("Failed to fetch from backend");
      }
      const result = await response.json();
      setSearchResult(result.slice(0, 5)); // Fetch the top 5 results
    } catch (error) {
      console.error("Error Message: " + error.message);
      setSearchResult([]); // Clear results in case of an error
    }
  };

  // Function to handle input focus
  const handleFocus = () => {
    setInputFocused(true);
  };

  // Function to handle input blur with a delay
  const handleBlur = () => {
    setTimeout(() => {
      setInputFocused(false);
    }, 150);
  };

  // Function to handle the search button click
  const handleSearch = () => {
    if (searchQuery.length >= 2) {
      fetchResults(searchQuery); // Trigger fetch for valid search queries
    }
  };

  return (
    <div className={styles.search_container}>
      {" "}
      {/* Container for the search bar */}
      <input
        type='text'
        placeholder='Search by key word or item name. . .'
        onChange={handleInputChange}
        onBlur={handleBlur}
        onFocus={handleFocus}
        aria-label='Search' // Accessibility label for screen readers
      />
      <button className={styles.search_button} onClick={handleSearch} aria-label='Search'>
        🔍 {/* Magnifying glass icon as a clickable button */}
      </button>
      <div className={`${styles.search_results} ${inputFocused ? styles.focused : undefined}`}>
        {" "}
        {/* Container for search results */}
        {!emptyQuery && inputFocused && <SearchResult results={searchResult}></SearchResult>}{" "}
        {/* Show results when input is focused and query is not empty */}
      </div>
    </div>
  );
};

export default SearchBar;
