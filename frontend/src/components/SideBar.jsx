import styles from "./Sidebar.module.css";

const Sidebar = ({ category, brand }) => {
  return (
    <div className={styles.sidebar}>
      <div>
        <h1>Filter By</h1>
      </div>
      <div>
        <h2>Brand</h2>
        <ul>
          {brand.map((brand, index) => (
            <li key={index}> {brand}</li>
          ))}
        </ul>
      </div>
      <div>
        <h2>Price</h2>
        <ul>
          <li>Under $10</li>
          <li>$10 to $30</li>
          <li>$30 to $50</li>
          <li>$50 to $70</li>
          <li>Over $70</li>
        </ul>
      </div>
      <div>
        <h2>Customer Rating</h2>
        <ul>
          <li>5 Stars</li>
          <li>4 Stars</li>
          <li>3 Stars</li>
          <li>2 Stars</li>
        </ul>
      </div>
    </div>
  );
};

export default Sidebar;
