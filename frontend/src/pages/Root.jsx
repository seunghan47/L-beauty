import React from "react";
import Header from "../components/Header";
import Footer from "../components/Footer";
import { Outlet, useLoaderData } from "react-router-dom";

const Root = () => {
  const data = useLoaderData();

  return (
    <div>
      <Header></Header>
      <Outlet />
      {console.log(data)}
      <Footer></Footer>
    </div>
  );
};

export default Root;
