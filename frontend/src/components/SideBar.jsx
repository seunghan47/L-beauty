import React from "react";
import styles from "./Sidebar.module.css";

const Sidebar = ({ category }) => {
  return (
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
  );
};

export default Sidebar;
