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
          {navLinks.map((link) => (
            <p key={link.path} className={`${styles.headerLinks} ${link.extraClass}`}>
              <Link to={link.path}>{link.label}</Link>
            </p>
          ))}
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
  { path: "/collections/hair_treatment", label: "Hair Care" },
  { path: "/collections/make_up", label: "Make-up" },
  { path: "/collections/nail", label: "Nail" },
  { path: "/collections/general_merchandise", label: "General Merchandise" },
];

const navLinks = [
  { path: "/about", label: "About", extraClass: "" },
  { path: "/jobs", label: "Careers", extraClass: "" },
  { path: "/add", label: "Item Suggestions", extraClass: styles.want },
];
