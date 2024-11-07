import styles from "./SearchResult.module.css";
import { Link } from "react-router-dom";

const SearchResult = ({ results }) => {
  const sendClicks = async (result) => {
    const now = new Date().toISOString();
    const url = "http://3.82.48.51:8080/newItem/save";
    // const url = "http://localhost:8082/clicked/clicked";
    try {
      const response = await fetch(url, {
        method: "POST",
        headers: {
          "content-type": "application/json",
        },
        body: JSON.stringify({
          upc: result.upc,
          name: result.name,
          date: now,
        }),
      });
      if (!response.ok) {
        throw new Error('failed to send result "SearchResult.jsx"');
      }
      console.log(`Sent ${result.name} successfully`);
    } catch (error) {
      console.log("error saving item");
    }
  };

  return (
    <div className={styles.search_result}>
      {results.map((result, index) => (
        <Link
          to={`/products/${result.upc}`}
          key={index}
          onClick={() => sendClicks(result)}
        >
          <li> {result.name}</li>
        </Link>
      ))}
    </div>
  );
};

export default SearchResult;
