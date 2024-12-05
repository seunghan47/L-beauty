import React from "react";
import styles from "./Loading.module.css";

const LoadingSpinner = () => {
  return (
    <div className={styles.loading_spinner}>
      <p className={styles.loading}>Loading...</p>
      <div className={styles.spinner}></div>
    </div>
  );
};

export default LoadingSpinner;
