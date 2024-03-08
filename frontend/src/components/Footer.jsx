import React from "react";
import styles from "./Footer.module.css";
import { Link } from "react-router-dom";
const Footer = () => {
  return (
    <footer className={styles.footer}>
      <div className={styles.flex_container}>
        <div className={styles.footer_flex}>
          <h3>Business Info</h3>
          <p>3360 Buena Vista Rd, Columbus, GA 31906</p>
          <p>Monday - Saturday: 9AM - 9PM</p>
          <p>Sunday: 10AM - 7PM</p>
          <p>Phone Number: (706) 221-6832</p>
        </div>
        <div className={styles.footer_flex}>
          <h3>GET DIRECTION</h3>
          <Link to='/about'>
            <p>ABOUT US</p>
          </Link>
          <Link to='/terms'>
            <p>TERMS OF SERVICE</p>
          </Link>
          <Link to='/refund'>
            <p>REFUND POLICY</p>
          </Link>
          <Link to='/jobs'>
            <p>JOBS</p>
          </Link>
        </div>
        <div className={styles.footer_flex}>
          <h3>NEWSLETTER</h3>
          <p>BE THE FIRST TO FIND OUT ABOUT OUR SALES</p>
          <input
            type='text'
            placeholder='Enter your email here'
          />
          <br />
          <button> SUBSCRIBE </button>
        </div>
        <div className={styles.footer_flex}>
          <h3>FIND US HERE TOO</h3>
          <a
            href='https://www.facebook.com/jbeautycolumbus'
            target='_blank'
            rel='noreferrer'
          >
            <img
              src='facebook.png'
              alt='facebook'
            />
          </a>

          <a
            href='https://www.instagram.com/jbeauty_ga/'
            target='_blank'
            rel='noreferrer'
          >
            <img
              src='instagram.png'
              alt='instagram'
            />
          </a>

          <a
            href='https://www.google.com/search?q=lbeauty&sca_esv=9fc63cc73e9e59b8&sxsrf=ACQVn0_lwftAp_AyNpB2jUkePeouKSrFkw%3A1709744478056&source=hp&ei=XqHoZZeGAZbdkPIP36-liA0&iflsig=ANes7DEAAAAAZeivbsI0zIdvKXZSS7Zr2kfgPtYBXpJH&ved=0ahUKEwiXrZPCjuCEAxWWLkQIHd9XCdEQ4dUDCBc&uact=5&oq=lbeauty&gs_lp=Egdnd3Mtd2l6IgdsYmVhdXR5MgoQIxiABBiKBRgnMg0QABiABBgKGLEDGMkDMgcQABiABBgKMgsQABiABBiKBRiSAzIKEAAYgAQYChixAzIHEAAYgAQYCjIHEAAYgAQYCjIQEC4YgAQYChjHARivARiOBTIHEAAYgAQYCjINEAAYgAQYChixAxiDAUjJB1AAWJYGcAB4AJABAJgBiAGgAbAFqgEDNS4yuAEDyAEA-AEBmAIHoALEBcICBBAjGCfCAhAQLhiABBiKBRhDGMcBGK8BwgIOEC4YgAQYsQMYxwEY0QPCAg4QLhiABBjHARivARiOBcICCxAAGIAEGLEDGIMBwgIREC4YgAQYsQMYgwEYxwEY0QPCAggQABiABBixA8ICCxAuGIAEGLEDGIMBwgIFEC4YgATCAgUQABiABMICCxAuGIAEGMcBGK8BwgIQEC4YgAQYChixAxjHARjRA8ICDRAuGIAEGMcBGNEDGArCAgoQABiABBjJAxgKwgINEC4YgAQYxwEYrwEYCsICEBAuGAoYrwEYxwEYgAQYjgWYAwCSBwMzLjSgB_9X&sclient=gws-wiz#lrd=0x88f3336ac0741755:0x338ec7e7dcf50888,1,,,,'
            target='_blank'
            rel='noreferrer'
          >
            <img
              src='google.jpeg'
              alt='google'
            />
          </a>
        </div>
      </div>
      <hr />
      <div className={styles.flex_container}>
        <div className={styles.copyright}>
          <p>© 2023 All rights reserved | Paul Lim</p>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
