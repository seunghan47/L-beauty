import React from "react";
import { Link } from "react-router-dom";

const DUMMY_PRODUCTS = [
  { id: 1, name: "weave" },
  { id: 2, name: "wig" },
  { id: 3, name: "nails" },
  { id: 4, name: "skincare" },
];

const Products = () => {
  return (
    <div>
      <h1>this is products</h1>
      <ul>
        {DUMMY_PRODUCTS.map((product) => (
          <li key={product.id}>
            <Link to={`/products/${product.id}`}>{product.name}</Link>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Products;
