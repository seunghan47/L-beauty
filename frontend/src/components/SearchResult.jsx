import React from "react";
import styles from "./SearchResult.module.css";
import { Link } from "react-router-dom";

const SearchResult = ({ results }) => {
  const clicked = () => {
    console.log("clicked");
  };

  return (
    <div className={styles.search_result}>
      {results.map((result, index) => (
        <Link
          to={`/products/${result.upc}`}
          key={index}
          onClick={clicked}
        >
          <li> {result.name}</li>
        </Link>
      ))}
    </div>
  );
};

export default SearchResult;
