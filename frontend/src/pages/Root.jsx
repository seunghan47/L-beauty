import React from "react";
import Header from "../components/Header";
import Footer from "../components/Footer";
import { Outlet } from "react-router-dom";

const Root = () => {
  return (
    <div>
      <Header />
      <Outlet />
      <Footer />
    </div>
  );
};

export default Root;

export async function loader() {
  const url = "http://3.82.48.51:8080/Search/all";
  // const url = "http://localhost:8082/Search/all";
  const response = await fetch(url);
  if (!response.ok) {
    throw new Error("error fetching from databse. check backend!");
  } else {
    const responseData = await response.json();
    return responseData;
  }
}

//verifying jenkins configuration
