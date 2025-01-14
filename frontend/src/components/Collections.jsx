import React, { useEffect, useState } from "react";
import { useParams, useSearchParams } from "react-router-dom";
import styles from "./Collections.module.css";
import Sidebar from "./SideBar";

const Collections = () => {
  const { category } = useParams();
  const [products, setProducts] = useState([]);
  const [searchParams, setSearchParams] = useSearchParams();

  const page = parseInt(searchParams.get("page") || "0", 10);
  const size = parseInt(searchParams.get("size") || "24", 10);

  useEffect(() => {
    const fetchCollections = async () => {
      try {
        const response = await fetch(
          `https://api2.lbeautysupplies.com/collections/${category}?page=${page}&size=${size}`
        );
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
      <Sidebar category={category} />

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
                <span className={styles.salePrice}>${product.price}</span>
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
