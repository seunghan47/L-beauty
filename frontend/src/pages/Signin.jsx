import React from "react";
import styles from "./Signup.module.css";
import { Link } from "react-router-dom";

const Signin = () => {
  return (
    <div className={styles.loginsignup}>
      <div className={styles.loginsignup_container}>
        <h1>Sign in</h1>
        <div className={styles.loginsignup_fields}>
          <input
            type='email'
            placeholder='Email Address'
          />
          <input
            type='password'
            placeholder='Password'
          />
        </div>
        <button>Continue</button>
        <p className={styles.loginsignup_login}>
          Don't have an account?{" "}
          <span>
            <Link to='/login'>Sign up here</Link>
          </span>
        </p>
      </div>
    </div>
  );
};

export default Signin;
