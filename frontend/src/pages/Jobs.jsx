import React from "react";
// import { Form } from "react-router-dom";
import styles from "./Jobs.module.css";
//name email phone location message
const Jobs = () => {
  return (
    <>
      <div className={styles.jobs_container}>
        <h1>We're Hiring!</h1>
        <span className={styles.span_paragraph}>
          <p>Fill out this form and we will get back to you as soon as we can !</p>
        </span>
        <form
          method='post'
          action='/jobs'
        >
          <div className={styles.label_input}>
            <label htmlFor='name'>
              <p>Name: </p>
              <input
                type='text'
                id='name'
                name='name'
              ></input>
            </label>
          </div>
          <div className={styles.label_input}>
            <label htmlFor='email'>
              <p>Email: </p>
              <input
                type='text'
                id='email'
                name='email'
              ></input>
            </label>
          </div>
          <div className={styles.label_input}>
            <label htmlFor='Phone'>
              <p>Phone: </p>
              <input
                type='tel'
                id='Phone'
                name='Phone'
              ></input>
            </label>
          </div>
          <div className={styles.label_input}>
            <label htmlFor='Location'>
              <div className={styles.location}>
                <p>Location Preference Below: </p>
                <br />
                <input
                  type='checkbox'
                  id='Location'
                  name='Location'
                />
                <p>L Beauty</p>
              </div>
              <div className={styles.location}>
                <input
                  type='checkbox'
                  id='Location'
                  name='Location'
                />
                <p>J Beauty</p>
              </div>
              <div className={styles.location}>
                <input
                  type='checkbox'
                  id='Location'
                  name='Location'
                />
                <p>Nice Beauty</p>
              </div>
              <div className={styles.location}>
                <input
                  type='checkbox'
                  id='Location'
                  name='Location'
                />
                <p>Hi Beauty</p>
              </div>
            </label>
          </div>
          <div className={styles.label_input}>
            <label htmlFor='message'>
              <p style={{ marginBottom: "16px" }}>Message: </p>
              <br />
              <textarea
                type='text'
                id='message'
                name='message'
              />
            </label>
          </div>
          <button className={styles.button}>Submit Form!</button>
        </form>
      </div>
    </>
  );
};

export default Jobs;
