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
  // const response = await fetch("http://3.82.194.52:8080/Search/all");
  const response = await fetch("http://localhost:8082/Search/all");
  if (!response.ok) {
    throw new Error("error fetching from databse");
  } else {
    const responseData = await response.json();
    return responseData;
  }
}
