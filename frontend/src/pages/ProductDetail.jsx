import React from "react";
import { useLoaderData, useParams } from "react-router-dom";
import styles from "./ProductDetail.module.css";

const ProductDetail = () => {
  const params = useParams();
  const items = useLoaderData();
  const selectedItem = items.find((item) => item.upc === params.upc);
  const random = Math.round(Math.random(100) * 100);
  return (
    <div className={styles.product_detail_page}>
      <div className={styles.product_detail_left}>
        <img
          src='/notfound.jpeg'
          alt=''
        />
        <div className={styles.image_row}>
          <img
            src='/notfound.jpeg'
            alt='notfound'
          />
          <img
            src='/notfound.jpeg'
            alt='notfound'
          />
          <img
            src='/notfound.jpeg'
            alt='notfound'
          />
          <img
            src='/notfound.jpeg'
            alt='notfound'
          />
          <img
            src='/notfound.jpeg'
            alt='notfound'
          />
        </div>
      </div>
      <div className={styles.product_detail_right}>
        <h2
          style={{
            backgroundColor: "#FFCCCC",
            display: "inline-block",
            padding: "10px",
            borderRadius: "10px",
            margin: "0",
          }}
        >
          NEW
        </h2>
        <h2>{selectedItem.name}</h2>
        <h2>Item Number: {params.upc}</h2>
        <h2>${selectedItem.price}</h2>
        <p>
          <ion-icon name='star'></ion-icon>
          <ion-icon name='star'></ion-icon>
          <ion-icon name='star'></ion-icon>
          <ion-icon name='star'></ion-icon>
          <ion-icon name='star'></ion-icon>
          <span className={styles.rating}>5.0 ({random})</span> write a review
        </p>
        <button className={styles.button}>Save!</button>
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
