import React from "react";

const MaintenancePage = () => {
  return (
    <div style={styles.container}>
      <h1 style={styles.title}>We’re Currently Under Maintenance</h1>
      <p style={styles.message}>Our site is undergoing scheduled maintenance. Please check back later.</p>
    </div>
  );
};

const styles = {
  container: {
    textAlign: "center",
    padding: "2rem",
    fontFamily: "Arial, sans-serif",
    color: "#333",
    backgroundColor: "#f8f8f8",
    height: "100vh",
    display: "flex",
    flexDirection: "column",
    justifyContent: "center",
    alignItems: "center",
  },
  title: {
    fontSize: "2rem",
    marginBottom: "1rem",
  },
  message: {
    fontSize: "1.2rem",
  },
};

export default MaintenancePage;
