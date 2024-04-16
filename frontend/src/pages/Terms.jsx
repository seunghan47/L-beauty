import React, { useEffect, useState } from "react";
import Fetching from "./Fetching";

const Terms = () => {
  const url = "http://localhost:8080/Search/all";
  const [data, setData] = useState([]);
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    setIsLoading(true);
    const fetchData = async () => {
      try {
        const response = await fetch(url, {});
        if (!response.ok) {
          throw new Error("error fetching from URL");
        } else {
          const responseData = await response.json();
          setData(responseData);
        }
      } catch (error) {
        console.log(error.message);
      }
      setIsLoading(false);
    };

    fetchData();
  }, []);

  return (
    <>
      {isLoading && <Fetching />}
      {!isLoading &&
        data.map((item, index) => (
          <ul key={index}>
            <li>{item.name}</li>
            <li>{item.price}</li>
            <li>{item.upc}</li>
          </ul>
        ))}
    </>
  );
};

export default Terms;
