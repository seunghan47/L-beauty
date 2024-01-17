import React from "react";
import styles from "./Signup.module.css";
import { Link } from "react-router-dom";

const LoginSignup = () => {
  return (
    <div className={styles.loginsignup}>
      <div className={styles.loginsignup_container}>
        <h1>Sign Up</h1>
        <div className={styles.loginsignup_fields}>
          <input
            type='text'
            placeholder='Your Name'
          />
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
          Already have an account?{" "}
          <span>
            <Link to='/signin'>Login here</Link>
          </span>
        </p>
        {/* <div className={styles.loginsignup_agree}>
          <input
            type='checkbox'
            name=''
            id=''
          />
          <p>By continuing, i agree to the terms of use & privacy policy.</p>
        </div> */}
      </div>
    </div>
  );
};

export default LoginSignup;
