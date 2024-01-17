import React from "react";
import { useParams } from "react-router-dom";

const ProductDetail = () => {
  const params = useParams();

  return (
    <div>
      <h1>this is a product detail page</h1>
      <h1>{params.productId}</h1>
    </div>
  );
};

export default ProductDetail;
