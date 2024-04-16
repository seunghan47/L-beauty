import React, { useState } from "react";
import styles from "./Add.module.css";

const url = "http://localhost:8080/newItem/save";

const Add = () => {
  const date = new Date();
  const day = date.toISOString().split("T")[0];
  const [formdata, setFormData] = useState({
    name: "",
    company: "",
    file: "",
    date: "",
    email: "",
  });

  function inputChange(identifier, value) {
    setFormData((prev) => ({
      ...prev,
      [identifier]: value,
    }));
  }

  return (
    <>
      <span className={styles.title}>
        <h1>ITEM SUGGESTION</h1>
        <p>Have an item you want to get in the store? fill out this form and we will get it as soon as we can!</p>
      </span>

      <form
        className={styles.form}
        onSubmit={postingForm}
      >
        <img
          src='form.jpg'
          alt=''
        />
        <div className={styles.form_container}>
          <div className={styles.form_element}>
            <label htmlFor='name'>Name of the Product (Required)</label>
            <input
              type='text'
              value={formdata.name}
              onChange={(event) => inputChange("name", event.target.value)}
              name='name'
              required
            />
          </div>
          <div className={styles.form_element}>
            <label htmlFor='email'>Enter your email (Required, so we can get back to you!)</label>
            <input
              type='text'
              value={formdata.email}
              onChange={(event) => inputChange("email", event.target.value)}
              name='email'
              required
            />
          </div>
          <div className={styles.form_element}>
            <label htmlFor='company'>Company of the Product (Optional)</label>
            <input
              type='text'
              placeholder='name of company'
              onChange={(event) => inputChange("company", event.target.value)}
              name='company'
            />
          </div>
          <div className={styles.form_element}>
            <label htmlFor='file'>Files image (Optional)</label>
            <input
              type='file'
              onChange={(event) => inputChange("file", event.target.value)}
              name='file'
            />
          </div>
          <div className={styles.form_element}>
            <label htmlFor='date'>Date you need the item by (Optional)</label>
            <input
              type='date'
              min={day}
              onChange={(event) => inputChange("date", event.target.value)}
              name='date'
            />
          </div>
          <button>Submit!</button>
        </div>
      </form>
    </>
  );
};

export default Add;

async function postingForm(e) {
  e.preventDefault();
  const fd = new FormData(e.target);
  const data = Object.fromEntries(fd.entries());

  try {
    const response = await fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    });
    if (!response) {
      throw new Error("failed sending form !! line 98");
    }
    const responseData = await response.json();
    console.log(responseData);
  } catch (error) {
    console.log("error: " + error.message);
  }
}
