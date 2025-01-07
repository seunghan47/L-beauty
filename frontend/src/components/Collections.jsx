import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import styles from "./Collections.module.css";

const Collections = () => {
  const { category } = useParams();
  const [loading, setLoading] = useState(true);
  const [products, setProducts] = useState([]);

  useEffect(() => {
    const fetchCollections = async () => {
      setLoading(true);
      try {
        const response = await fetch(`http://localhost:8081/collections/${category}`);
        if (!response.ok) {
          throw new Error(`HTTP response: ${response.status}`);
        }
        const data = await response.json();
        setProducts(data);
      } catch (error) {
        console.error("error: " + error);
        setProducts([]);
      } finally {
        setLoading(false);
      }
    };
    fetchCollections();
  }, [category]);

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
        <h1>LAYOUT UPDATE COMING SOON</h1>
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
      </div>
    </div>
  );
};

export default Collections;
