import React, { useEffect, useState } from "react";
import { useParams, useSearchParams } from "react-router-dom";
import styles from "./Collections.module.css";

const Collections = () => {
  const { category } = useParams();
  const [products, setProducts] = useState([]);
  const [searchParams, setSearchParams] = useSearchParams();

  const page = parseInt(searchParams.get("page") || "0", 10);
  const size = parseInt(searchParams.get("size") || "24", 10);

  useEffect(() => {
    const fetchCollections = async () => {
      try {
        const response = await fetch(`http://localhost:8081/collections/${category}?page=${page}&size=${size}`);
        if (!response.ok) {
          throw new Error(`HTTP response: ${response.status}`);
        }
        const data = await response.json();
        setProducts(data);
      } catch (error) {
        console.error("error: " + error);
        setProducts([]);
      }
    };
    fetchCollections();
  }, [category, size, page]);

  const handlePageChange = (newPage) => {
    if (newPage >= 0) {
      setSearchParams({ page: newPage, size });
    }
  };

  return (
    <div className={styles.collectionsContainer}>
      <div className={styles.sidebar}>
        <h3>Refine</h3>
        <div>
          <h4>Type</h4>
          <p>• {category.replace("-", " ")}</p>
        </div>
        <div>
          <h4>Brand</h4>
          <ul>
            <li>ACME East</li>
            <li>Coaster Z2 Premium</li>
            <li>Ashley Furniture</li>
          </ul>
        </div>
        <div>
          <h4>Price</h4>
          <ul>
            <li>Under $500</li>
            <li>$500 to $1,000</li>
            <li>$1,000 to $1,500</li>
            <li>$1,500 to $2,000</li>
            <li>Over $2,500</li>
          </ul>
        </div>
      </div>

      <div className={styles.mainContent}>
        <p>
          Showing 1 - {products.length} of {products.length} products
        </p>
        <div className={styles.productGrid}>
          {products.map((product) => (
            <div key={product.id} className={styles.productCard}>
              <h4>{product.brand}</h4>
              <p>{product.name}</p>
              <p className={styles.price}>
                <span className={styles.salePrice}>{product.price}</span>
              </p>
            </div>
          ))}
        </div>

        <div className={styles.paginationControls}>
          <button onClick={() => handlePageChange(page - 1)} disabled={page === 0}>
            Previous
          </button>

          <button onClick={() => handlePageChange(page + 1)}>Next</button>
        </div>
      </div>
    </div>
  );
};

export default Collections;
