import { createAsyncThunk } from "@reduxjs/toolkit";
import fetchData from "../api/fetchData";

export const fetchProducts = createAsyncThunk("products/fetchProducts", async (products) => {
  const response = await fetchData(`products?category=${products}`);
  return response;
});
