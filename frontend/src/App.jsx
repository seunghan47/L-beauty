import { createBrowserRouter, RouterProvider } from "react-router-dom";
import ProductDetail from "./pages/ProductDetail";
import ErrorPage from "./pages/ErrorPage";
import Products from "./pages/Products";
import Signup from "./pages/Signup";
import Signin from "./pages/Signin";
import Home from "./pages/Home";
import Root from "./pages/Root";
import Jobs from "./pages/Jobs";
import "./App.css";
import Add from "./pages/Add";
import Terms from "./pages/Terms";
import RefundPolicy from "./pages/RefundPolicy";
import ScrollToTop from "./util/ScrollToTop";
import AboutUs from "./pages/AboutUs";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Root />,
    errorElement: <ErrorPage />,
    loader: async () => {
      const response = await fetch("http://3.82.194.52:8080/Search/all");
      // const response = await fetch("http://localhost:8080/Search/all");
      if (!response.ok) {
        throw new Error("error fetching from databse");
      } else {
        const responseData = await response.json();
        return responseData;
      }
    },
    children: [
      { index: true, element: <Home /> },
      { path: "products", element: <Products /> },
      { path: "about", element: <AboutUs /> },
      { path: "products/:productId", element: <ProductDetail /> },
      { path: "login", element: <Signup /> },
      { path: "signin", element: <Signin /> },
      { path: "jobs", element: <Jobs /> },
      { path: "add", element: <Add /> },
      { path: "terms", element: <Terms /> },
      { path: "refund", element: <RefundPolicy /> },
    ],
  },
]);

function App() {
  return (
    <RouterProvider router={router}>
      <ScrollToTop />
    </RouterProvider>
  );
}

export default App;
