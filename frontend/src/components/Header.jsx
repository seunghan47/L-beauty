import React, { useState } from "react";
import styles from "./Header.module.css";

import { Link } from "react-router-dom";

const Header = () => {
  const [menu, setMenu] = useState(false);

  const toggleNav = () => {
    setMenu((prev) => !prev);
  };

  return (
    <header>
      <div className={styles.flex_container}>
        <Link to='/'>
          <img
            src='lbeauty.jpeg'
            alt=''
          />
        </Link>
        <label htmlFor='search'></label>
        <input
          type='text'
          placeholder='Search by key word or item name. . .'
          // className={`${menu ? styles.close : undefined}`}
        />
        <nav className={`${styles.nav_container} ${menu ? undefined : styles.close}`}>
          <p className={styles.headerLinks}>
            <Link to='/signin'>Sign In</Link>
          </p>
          <p className={styles.headerLinks}>
            <Link to='/cart'>Cart </Link>
          </p>
          <p className={`${styles.headerLinks} ${styles.want}`}>
            <Link to='/add'>I WANT</Link>
          </p>
        </nav>
        <div
          className={styles.hamburger}
          onClick={toggleNav}
        >
          <div className={styles.bar}></div>
          <div className={styles.bar}></div>
          <div className={styles.bar}></div>
        </div>
      </div>

      <div className={styles.merchandise_container}>
        <p>
          <Link to='products'>Hair</Link>
        </p>
        <p>Hair Care</p>
        <p>Hair Styling</p>
        <p>Tools & Brushes</p>
        <p>Make-up</p>
        <p>Skin Care</p>
        <p>Nail</p>
      </div>
    </header>
  );
};

export default Header;
