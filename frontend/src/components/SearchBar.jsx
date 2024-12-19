import React from "react";
import { useState } from "react";
import styles from "./SearchBar.module.css";
import SearchResult from "./SearchResult";

const SearchBar = ({}) => {
  const [inputFocused, setInputFocused] = useState(false);
  const [emptyQuery, setEmptyQuery] = useState(true);
  const [searchResult, setSearchResult] = useState([]);

  const handleInputChange = async (event) => {
    const query = event.target.value;
    if (query === "") {
      setEmptyQuery(true);
    } else {
      setEmptyQuery(false);
    }

    if (query.length < 2) {
      setSearchResult([]);
      return;
    }

    try {
      // const response = await fetch(`https://api.lbeautysupplies.com/search/query?term=${query}`);
      const response = await fetch(`http://localhost:8081/search/query?term=${query}`);
      // const response = await fetch(`http://54.167.105.44:8080/search/query?term=${query}`);
      if (!response.ok) {
        throw new Error("Failed to fetch from backend");
      }
      const result = await response.json();
      console.log(result);
      setSearchResult(result.slice(0, 5));
    } catch (error) {
      console.error("Error Message: " + error.message);
      setSearchResult([]);
    }
  };

  const handleFocus = () => {
    setInputFocused(true);
  };

  const handleBlur = () => {
    setTimeout(() => {
      setInputFocused(false);
    }, 150);
  };

  return (
    <div className={styles.search_container}>
      <input
        type='text'
        placeholder='Search by key word or item name. . .'
        onChange={handleInputChange}
        onBlur={handleBlur}
        onFocus={handleFocus}
        aria-label='Search'
      />

      <div className={`${styles.search_results} ${inputFocused ? styles.focused : undefined}`}>
        {!emptyQuery && inputFocused && <SearchResult results={searchResult}></SearchResult>}
      </div>
    </div>
  );
};

export default SearchBar;
