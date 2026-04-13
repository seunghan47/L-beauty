const BASE_URL = "http://localhost:8080/api";

const fetchData = async (endpoint = "", options = {}) => {
  let url = `${BASE_URL}/${endpoint}`;

  if (options.params) {
    const queryParams = new URLSearchParams(options.params).toString();
    url += `?${queryParams}`;
  }

  try {
    const response = await fetch(url, options);
    if (!response.ok) {
      if (response.status === 401) console.warn("Authentication Required!");
      throw new Error(`HTTP ERROR: ${response.status}`);
    }
    return await response.json();
  } catch (error) {
    console.error("Fetch Error: ", error);
    throw error;
  }
};
