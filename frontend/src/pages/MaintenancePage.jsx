import React from "react";
import styles from "./MaintenancePage.module.css";

const MaintenancePage = () => {
  const date = new Date();
  return (
    <div className={styles.container}>
      <h1 className={styles.title}>We're Currently Under Maintenance</h1>
      <p className={styles.message}>Our site is undergoing scheduled maintenance. Please check back later.</p>
      <p className={styles.message}>{date.toISOString()}</p>
    </div>
  );
};

export default MaintenancePage;
