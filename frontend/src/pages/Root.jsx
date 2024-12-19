import React, { Suspense } from "react";
import { Outlet } from "react-router-dom";
import Header from "../components/Header";
import Footer from "../components/Footer";
import Loading from "../components/Loading";

const Root = () => {
  return (
    <div>
      <Header />
      <Suspense fallback={<Loading />} />
      <Outlet />
      <Footer />
    </div>
  );
};

export default Root;

export async function loader() {
  return null;
}
