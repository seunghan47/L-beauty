import React, { useState } from "react";
import styles from "./Header.module.css";
import { useLoaderData } from "react-router-dom";
import { Link } from "react-router-dom";
import SearchResult from "./SearchResult";

const Header = () => {
  const [menu, setMenu] = useState(false);
  const [searchResult, setSearchResult] = useState([]);
  const [emptyQuery, setEmptyQuery] = useState(true);
  const [inputFocused, setInputFocused] = useState(false);
  const data = useLoaderData();

  const toggleNav = () => {
    setMenu((prev) => !prev);
  };

  const handleInputChange = (event) => {
    const query = event.target.value;
    if (query === "") {
      setEmptyQuery(true);
    } else {
      setEmptyQuery(false);
    }

    const result = data.filter((item) => item.name.toLowerCase().includes(query.toLowerCase()));

    setSearchResult(result.slice(0, 5));
  };

  const handleFocus = () => {
    setInputFocused(true);
  };

  const handleBlur = () => {
    setTimeout(() => {
      setInputFocused(false);
    }, 150);
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
        <div className={styles.search_container}>
          <input
            type='text'
            placeholder='Search by key word or item name. . .'
            onChange={handleInputChange}
            onBlur={handleBlur}
            onFocus={handleFocus}
          />
          <div className={`${styles.search_results} ${inputFocused ? styles.focused : undefined}`}>
            {!emptyQuery && inputFocused && <SearchResult results={searchResult}></SearchResult>}
          </div>
        </div>
        <nav className={`${styles.nav_container} ${menu ? undefined : styles.close}`}>
          <p className={styles.headerLinks}>
            <Link to='/jobs'>Careers</Link>
          </p>
          <p className={`${styles.headerLinks} ${styles.want}`}>
            <Link to='/add'>Item Suggestions</Link>
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
