import { createBrowserRouter, RouterProvider } from "react-router-dom";
import ProductDetail from "./pages/ProductDetail";
import ErrorPage from "./pages/ErrorPage";
import Products from "./pages/Products";
import Signup from "./pages/Signup";
import Signin from "./pages/Signin";
import Home from "./pages/Home";
import Root from "./pages/Root";
import Jobs from "./pages/Jobs";
import Add from "./pages/Add";
import "./App.css";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Root />,
    errorElement: <ErrorPage />,
    children: [
      { index: true, element: <Home /> },
      { path: "products", element: <Products /> },
      { path: "products/:productId", element: <ProductDetail /> },
      { path: "login", element: <Signup /> },
      { path: "signin", element: <Signin /> },
      { path: "jobs", element: <Jobs /> },
      { path: "add", element: <Add /> },
    ],
  },
]);

function App() {
  return <RouterProvider router={router}></RouterProvider>;
}

export default App;
