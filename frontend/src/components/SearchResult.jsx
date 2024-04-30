import React from "react";
import styles from "./SearchResult.module.css";
import { Link } from "react-router-dom";

const SearchResult = ({ results }) => {
  return (
    <div className={styles.search_result}>
      {results.map((result, index) => (
        <Link
          to={`/products/${result.upc}`}
          key={index}
        >
          <li> {result.name}</li>
        </Link>
      ))}
    </div>
  );
};

export default SearchResult;
