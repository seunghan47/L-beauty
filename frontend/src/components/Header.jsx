import React, { useState } from "react";
import styles from "./Header.module.css";
import { Link } from "react-router-dom";
import SearchResult from "./SearchResult";
import SearchBar from "./SearchBar";

const Header = () => {
  const [menu, setMenu] = useState(false);

  const toggleNav = () => {
    setMenu((prev) => !prev);
  };

  return (
    <header>
      <div className={styles.flex_container}>
        <Link to='/'>
          <img src='/lbeauty.jpeg' alt='' className={styles.logo} />
        </Link>
        <SearchBar />
        <nav className={`${styles.nav_container} ${menu ? undefined : styles.close}`}>
          <p className={styles.headerLinks}>
            <Link to='/about'>About</Link>
          </p>
          <p className={styles.headerLinks}>
            <Link to='/jobs'>Careers</Link>
          </p>
          <p className={`${styles.headerLinks} ${styles.want}`}>
            <Link to='/add'>Item Suggestions</Link>
          </p>
        </nav>
        <div className={styles.hamburger} onClick={toggleNav}>
          <div className={styles.bar}></div>
          <div className={styles.bar}></div>
          <div className={styles.bar}></div>
        </div>
      </div>

      <div className={styles.merchandise_container}>
        <p>
          <Link to='/collections/hair'>Hair</Link>
        </p>
        <p>
          <Link to='/collections/hair-care'>Hair Care</Link>
        </p>
        <p>
          <Link to='/collections/hair-styling'>Hair Styling</Link>
        </p>
        <p>
          <Link to='/collections/tools-brushes'>Tools & Brushes</Link>
        </p>
        <p>
          <Link to='/collections/make-up'>Make-up</Link>
        </p>
        <p>
          <Link to='/collections/skin-care'>Skin Care</Link>
        </p>
        <p>
          <Link to='/collections/nail'>Nail</Link>
        </p>
      </div>
    </header>
  );
};

export default Header;
