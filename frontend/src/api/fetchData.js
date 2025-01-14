const BASE_URL = "http://localhost:8081";

const fetchData = async (endpoint = "", options = {}) => {
  try {
    const response = await fetch(`${BASE_URL}/${endpoint}`, options);
    if (!response.ok) {
      throw new Error(`HTTP ERROR: ${response.status}`);
    }
    const data = await response.json();
    console.log(data);
    return data;
  } catch (error) {
    console.error("Error: " + error);
  }
};

export default fetchData;
