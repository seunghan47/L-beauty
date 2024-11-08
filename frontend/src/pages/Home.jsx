import React from "react";
import styles from "./Home.module.css";
import Cards from "../components/Cards";
import Reasons from "../components/Reasons";
import { dummy_cards, dummy_reasons, trending } from "../components/dummy";

const Home = () => {
  return (
    <>
      <div className={styles.home}>
        <img
          src='sng.jpeg'
          alt='shake and go banner'
        />
      </div>
      <div>
        <h1>reasons to shop here</h1>
        <ul className={styles.flex_container}>
          {dummy_reasons.map((item) => (
            <Reasons
              key={item.id}
              image={item.image}
              head={item.head}
              para={item.para}
            />
          ))}
        </ul>
      </div>
      <div className={styles.home}>
        <img
          src='braiding.jpeg'
          alt='shake and go banner'
        />
      </div>
      <div>
        <h1>WHAT'S TRENDING</h1>
        <ul className={styles.flex_container}>
          {trending.map((item) => (
            <Reasons
              key={item.id}
              image={item.image}
              head={item.head}
              para={item.para}
            />
          ))}
        </ul>
      </div>
      <div className={styles.home}>
        <img
          src='ibiza.jpeg'
          alt='shake and go banner'
        />
      </div>
      <div className={styles.brands}>
        <h1>Search by brands</h1>
        <ul className={styles.flex_container}>
          {dummy_cards.map((itme, index) => (
            <Cards
              key={index}
              image={itme.image}
              description={itme.id}
            />
          ))}
        </ul>
      </div>
    </>
  );
};

export default Home;
