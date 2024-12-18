import React, { useEffect, useState } from "react";

const Collections = () => {
  const [data, setData] = useState([]);

  const getResult = async () => {
    try {
      const response = await fetch("localhost:8081/search/items");
      if (!response.ok) {
        throw new Error(`Error: ${response.status}`);
      }
      const result = await response.json();
      setData(result);
    } catch (err) {
      console.log(err);
    }
  };

  useEffect(() => {
    getResult();
  }, []);

  return <h1>{data}</h1>;
};
export default Collections;
