import styles from "./Products.module.css";

const Products = () => {
  return (
    <div className={styles.product_page}>
      <h1>this is products</h1>
      <div className={styles.product_container}>
        <div className={styles.product_left}>
          <img
            src='notfound.jpeg'
            alt=''
          />
        </div>
        <div className={styles.product_right}>
          <p style={{ backgroundColor: "#FBD9D3" }}>NEW</p>
          <h3>Name</h3>
          <h3>$Price</h3>
          <h3>UPC</h3>
        </div>
      </div>
    </div>
  );
};

export default Products;
