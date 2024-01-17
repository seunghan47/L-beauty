import React from "react";
import styles from "./Cards.module.css";

const Cards = ({ image, description }) => {
  return (
    <div className={styles.cardContainer}>
      <img
        className={styles.card}
        src={image}
        alt={description}
      />
    </div>
  );
};

export default Cards;
