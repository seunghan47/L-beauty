import React from "react";
import styles from "./SearchResult.module.css";
const SearchResult = ({ results }) => {
  return (
    <div className={styles.search_result}>
      {results.map((result, index) => (
        <li key={index}>{result.name}</li>
      ))}
    </div>
  );
};

export default SearchResult;
