import React from "react";
import { useLoaderData, useParams } from "react-router-dom";
import styles from "./ProductDetail.module.css";

const ProductDetail = () => {
  const params = useParams();
  const items = useLoaderData();
  const selectedItem = items.find((item) => item.upc === params.upc);

  return (
    <div className={styles.product_detail_page}>
      <div className={styles.product_detail_left}>
        <img
          src='/notfound'
          alt=''
        />
        <h1>hello world</h1>
        <h2>df</h2>
      </div>
      <div className={styles.product_detail_right}>
        <h2>{selectedItem.name}</h2>
        <h1>{params.upc}</h1>
      </div>
    </div>
  );
};

export default ProductDetail;

export async function loader() {
  const response = await fetch("http://3.82.194.52:8080/Search/all");
  if (!response.ok) {
    console.log("hello");
  }
  const data = response.json();
  return data;
}
