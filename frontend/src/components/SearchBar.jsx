import React from "react";
import { useState } from "react";
import styles from "./SearchBar.module.css";
import SearchResult from "./SearchResult";
import fetchData from "../api/fetchData";

const SearchBar = () => {
  const [inputFocused, setInputFocused] = useState(false);
  const [emptyQuery, setEmptyQuery] = useState(true);
  const [searchResult, setSearchResult] = useState([]);

  const handleInputChange = async (event) => {
    const query = event.target.value.trim();
    setEmptyQuery(query === "");

    if (query.length < 2) {
      setSearchResult([]);
      return;
    }

    try {
      const result = await fetchData(`/inventory/query?term=${encodeURIComponent(query)}`);

      setSearchResult(result.slice(0, 5));
    } catch (error) {
      console.error("Error Message:", error.message);
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

      <div className={`${styles.search_results} ${inputFocused ? styles.focused : ""}`}>
        {!emptyQuery && inputFocused && <SearchResult results={searchResult} />}
      </div>
    </div>
  );
};

export default SearchBar;
