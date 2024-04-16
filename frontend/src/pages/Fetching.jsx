import React from "react";
import styles from "./Fetching.module.css";
const Fetching = () => {
  return (
    <div className={styles.fetching}>
      <h1>Fetching data . . .</h1>
      <p>hold on just a second</p>
    </div>
  );
};

export default Fetching;
