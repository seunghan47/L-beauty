import styles from "./Sidebar.module.css";

const Sidebar = ({ category, brand }) => {
  return (
    <div className={styles.sidebar}>
      <div>
        <h2>Filter By</h2>
      </div>
      <div>
        <h3>Brand</h3>
        {/* <ul>
          {brand.map((brand, index) => (
            <li key={index}> {brand}</li>
          ))}
        </ul> */}
      </div>
      <div>
        <h3>Price</h3>
        <ul>
          <li>Under $10</li>
          <li>$10 to $30</li>
          <li>$30 to $50</li>
          <li>$50 to $70</li>
          <li>Over $70</li>
        </ul>
      </div>
      <div>
        <h3>Customer Rating</h3>
        <ul>
          <li>5 Stars</li>
          <li>4 Stars</li>
          <li>3 Stars</li>
          <li>2 Stars</li>
          <li>1 Stars</li>
        </ul>
      </div>
    </div>
  );
};

export default Sidebar;
