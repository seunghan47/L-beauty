import React from "react";
import { Link } from "react-router-dom";

const ErrorPage = () => {
  return (
    <div style={styles.container}>
      <h1 style={styles.title}>Oops! We're doing some maintenance.</h1>
      <p style={styles.message}>We're currently making improvements to this page. Please check back in a few hours.</p>
      <Link
        to='..'
        style={styles.link}
      >
        Go Back to Safety
      </Link>
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
    marginBottom: "2rem",
  },
  link: {
    textDecoration: "none",
    padding: "0.5rem 1rem",
    backgroundColor: "#007BFF",
    color: "#fff",
    borderRadius: "5px",
    fontSize: "1rem",
  },
};

export default ErrorPage;
