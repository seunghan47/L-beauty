import styles from "./SearchResult.module.css";
import { Link } from "react-router-dom";
import fetchData from "../api/fetchData";

const SearchResult = ({ results }) => {
  const sendClicks = async (result) => {
    try {
      await fetchData("/clicked/clicked", {
        method: "POST",
        body: JSON.stringify({
          upc: result.upc,
          name: result.name,
          date: new Date().toISOString(),
        }),
      });

      console.log(`Sent ${result.name} successfully`);
    } catch (error) {
      console.error("Failed to POST clicked item:", error.message);
    }
  };

  return (
    <div className={styles.search_result}>
      {results.map((result) => (
        <Link to={`/products/${result.upc}`} key={result.upc} onClick={() => sendClicks(result)}>
          <li>{result.name}</li>
        </Link>
      ))}
    </div>
  );
};

export default SearchResult;
