import React from "react";
import { Form } from "react-router-dom";
import styles from "./Add.module.css";
const add = () => {
  const date = new Date();
  const day = date.toISOString().split("T")[0];

  const handleSubmit = () => {
    alert("we will get back to you shortly!");
    console.log("hello");
  };

  return (
    <>
      <span className={styles.title}>
        <h1>ITEM SUGGESTION</h1>
      </span>

      <Form className={styles.form}>
        <img
          src='form.jpg'
          alt=''
        />
        <div className={styles.form_container}>
          <div className={styles.form_element}>
            <label htmlFor='name'>Name of the Product (Required)</label>
            <input
              type='text'
              required
            />
          </div>
          <div className={styles.form_element}>
            <label htmlFor='company'>Company of the Product (Optional)</label>
            <input
              type='text'
              placeholder='name of company'
            />
          </div>
          <div className={styles.form_element}>
            <label htmlFor=''>File image (Optional)</label>
            <input type='file' />
          </div>
          <div className={styles.form_element}>
            <label htmlFor='date'>Date you need the item by (Optional)</label>
            <input
              type='date'
              min={day}
            />
          </div>
          <button onSubmit={handleSubmit}>Submit!</button>
        </div>
      </Form>
    </>
  );
};

export default add;