import React from "react";

const SearchResult = ({ results }) => {
  return (
    <div>
      {results.map((result, index) => (
        <li key={index}>{result.name}</li>
      ))}
    </div>
  );
};

export default SearchResult;
