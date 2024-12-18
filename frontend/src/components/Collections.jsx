import React from "react";
import { useParams } from "react-router-dom";
import styles from "./Collections.module.css";

const products = [
  {
    id: 1,
    brand: "Beauty Essentials",
    name: "Long Straight Synthetic Wig - Natural Black",
    price: "$49.99",
    originalPrice: "$79.99",
    discount: "38%",
    image: "/images/wig1.jpg",
  },
  {
    id: 2,
    brand: "Luxe Hair Care",
    name: "Argan Oil Hair Repair Shampoo & Conditioner Set",
    price: "$29.99",
    originalPrice: "$39.99",
    discount: "25%",
    image: "/images/haircare1.jpg",
  },
  {
    id: 3,
    brand: "Thread & Weave Co.",
    name: "100% Cotton Sewing Thread - 12 Pack (Assorted Colors)",
    price: "$12.99",
    originalPrice: "$18.99",
    discount: "32%",
    image: "/images/thread1.jpg",
  },
  {
    id: 4,
    brand: "Beauty Basics",
    name: "Edge Control Gel for Natural Hair - 100ml",
    price: "$8.49",
    originalPrice: "$12.99",
    discount: "35%",
    image: "/images/edgecontrol.jpg",
  },
  {
    id: 5,
    brand: "Fashion Fit",
    name: "Cotton V-Neck T-Shirt - White (Pack of 3)",
    price: "$19.99",
    originalPrice: "$29.99",
    discount: "33%",
    image: "/images/clothes1.jpg",
  },
  {
    id: 6,
    brand: "Weave Essentials",
    name: "Brazilian Curly Hair Weave - 18 Inches",
    price: "$69.99",
    originalPrice: "$99.99",
    discount: "30%",
    image: "/images/weave1.jpg",
  },
];

const Collections = () => {
  const { category } = useParams();

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

      {/* Main Content */}
      <div className={styles.mainContent}>
        {/* <h1>{category.replace("-", " ").toUpperCase()}</h1> */}
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
