import React, { Suspense } from "react";
import { Outlet } from "react-router-dom";
import Header from "../components/Header";
import Footer from "../components/Footer";
import Loading from "../components/Loading";

const Root = () => {
  // const navigation = useNavigation();
  // const isLoading = navigation.state === "loading";

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
  // const url = "https://api.lbeautysupplies.com/Search/all";
  // const response = await fetch(url);
  // if (!response.ok) {
  //   throw new Error("error fetching from databse. check backend!");
  // } else {
  //   const responseData = await response.json();
  //   return responseData;
  // }
  return null;
}

// const url = "http://3.82.48.51:8080/Search/all"
// const url = "http://localhost:8082/Search/all";
