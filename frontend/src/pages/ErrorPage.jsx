import React from "react";
import { Link } from "react-router-dom";

const ErrorPage = () => {
  return (
    <div>
      <h1>Oops, looks like this page hasn't been developed yet</h1>
      <h1>
        click <Link to='..'>this</Link> to go back
      </h1>
    </div>
  );
};

export default ErrorPage;
