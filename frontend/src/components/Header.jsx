import React, { useState } from "react";
import styles from "./Header.module.css";

import { Link } from "react-router-dom";

const Header = () => {
  const [menu, setMenu] = useState(false);

  const toggleMenu = () => {
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
        />
        {/* <img
          className={styles.search}
          src='search.png'
          alt=''
        /> */}
        <p className={styles.headerLinks}>
          <Link to='/login'>Sign Up</Link>
        </p>
        <p className={styles.headerLinks}>
          <Link to='/signin'>Sign In</Link>
        </p>
        <p className={styles.headerLinks}>
          <Link to='/cart'>Cart </Link>
        </p>
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
