import { createBrowserRouter, RouterProvider } from "react-router-dom";
import { loader as itemLoader } from "./pages/ProductDetail";
import ProductDetail from "./pages/ProductDetail";
import ErrorPage from "./pages/ErrorPage";
import Products from "./pages/Products";
import Signup from "./pages/Signup";
import Signin from "./pages/Signin";
import Home from "./pages/Home";
import Root, { loader as headerloader } from "./pages/Root";
import Jobs from "./pages/Jobs";
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
    loader: headerloader,
    children: [
      { index: true, element: <Home /> },
      { path: "products/:upc", element: <ProductDetail />, loader: itemLoader },
      { path: "about", element: <AboutUs /> },
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
