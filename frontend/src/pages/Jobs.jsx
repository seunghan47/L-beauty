import React, { useState } from "react";
import styles from "./Jobs.module.css";
import { useNavigate } from "react-router-dom";
import fetchData from "../api/fetchData";

const Jobs = () => {
  const navigate = useNavigate();
  const [formdata, setFormData] = useState({
    name: "",
    email: "",
    phone: "",
    message: "",
  });

  function inputChange(id, value) {
    setFormData((prev) => ({
      ...prev,
      [id]: value,
    }));
  }
  //
  async function postingForm(e) {
    e.preventDefault();

    try {
      const responseData = await fetchData("/career/addCareer", {
        method: "POST",
        body: JSON.stringify(formdata),
      });

      alert("Form sent, we will get back to you shortly ");
      console.log(responseData);
      navigate("/");
    } catch (error) {
      console.log("error: " + error.message);
    }
  }

  return (
    <>
      <div className={styles.jobs_container}>
        <h1>We're Hiring!</h1>
        <span className={styles.span_paragraph}>
          <p>Fill out this form and we will get back to you as soon as we can !</p>
        </span>
        <form onSubmit={postingForm}>
          <div className={styles.label_input}>
            <label htmlFor='name'>
              <p>Name: </p>
              <input type='text' name='name' onChange={(event) => inputChange("name", event.target.value)}></input>
            </label>
          </div>
          <div className={styles.label_input}>
            <label htmlFor='email'>
              <p>Email: </p>
              <input type='text' name='email' onChange={(event) => inputChange("email", event.target.value)}></input>
            </label>
          </div>
          <div className={styles.label_input}>
            <label htmlFor='Phone'>
              <p>Phone: </p>
              <input type='text' name='phone' onChange={(event) => inputChange("phone", event.target.value)}></input>
            </label>
          </div>

          <div className={styles.label_input}>
            <label htmlFor='message'>
              <p style={{ marginBottom: "16px" }}>Message: </p>
              <br />
              <textarea type='text' name='message' onChange={(event) => inputChange("message", event.target.value)} />
            </label>
          </div>
          <button className={styles.button}>Submit</button>
        </form>
      </div>
    </>
  );
};

export default Jobs;
