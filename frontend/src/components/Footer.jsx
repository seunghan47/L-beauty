import React from "react";
import styles from "./Footer.module.css";
const Footer = () => {
  return (
    <footer className={styles.footer}>
      <div className={styles.flex_container}>
        <div className={styles.footer_flex}>
          <h3>Business Info</h3>
          <p>3360 Buena Vista Rd, Columbus, GA 31906</p>
          <p>Monday - Saturday: 9AM - 9PM</p>
          <p>Sunday: 10AM - 7PM</p>
          <p>Phone Number: (706) 221-6832</p>
        </div>
        <div className={styles.footer_flex}>
          <h3>GET DIRECTION</h3>
          <p>ABOUT US</p>
          <p>TERMS OF SERVICE</p>
          <p>REFUND POLICY</p>
          <p>JOBS</p>
        </div>
        <div className={styles.footer_flex}>
          <h3>NEWSLETTER</h3>
          <p>BE THE FIRST TO FIND OUT ABOUT OUR SALES</p>
          <input
            type='text'
            placeholder='Enter your email here'
          />
          <br />
          <button> SUBSCRIBE </button>
        </div>
        <div className={styles.footer_flex}>
          <h3>FIND US HERE TOO</h3>
          <img
            src='facebook.png'
            alt='facebook'
          />
          <img
            src='instagram.png'
            alt='instagram'
          />
          <img
            src='google.jpeg'
            alt='google'
          />
        </div>
      </div>
      <hr />
      <div className={styles.flex_container}>
        <div className={styles.copyright}>
          <p>© 2023 All rights reserved | Paul Lim</p>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
