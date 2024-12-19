import React, { useState } from "react";
import styles from "./Header.module.css";
import { Link } from "react-router-dom";
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
        {merchandiseLinks.map((link) => (
          <p key={link.path}>
            <Link to={link.path}>{link.label}</Link>
          </p>
        ))}
      </div>
    </header>
  );
};

export default Header;

const merchandiseLinks = [
  { path: "/collections/hair", label: "Hair" },
  { path: "/collections/hair-care", label: "Hair Care" },
  { path: "/collections/hair-styling", label: "Hair Styling" },
  { path: "/collections/tools-brushes", label: "Tools & Brushes" },
  { path: "/collections/make-up", label: "Make-up" },
  { path: "/collections/skin-care", label: "Skin Care" },
  { path: "/collections/nail", label: "Nail" },
];
