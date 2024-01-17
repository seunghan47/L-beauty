import React from "react";
import styles from "./Reasons.module.css";

const Reasons = ({ image, head, para }) => {
  return (
    <div className={styles.flex_items}>
      <img
        src={image}
        alt=''
      />
      <h2>{head}</h2>
      <p>{para}</p>
    </div>
  );
};

export default Reasons;
