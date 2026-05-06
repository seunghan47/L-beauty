const API_BASE_URL = (process.env.REACT_APP_API_BASE_URL || "http://localhost:8080/api").replace(/\/$/, "");

async function fetchData(endpoint, options = {}) {
  const response = await fetch(`${API_BASE_URL}${endpoint}`, {
    headers: {
      "Content-Type": "application/json",
      ...options.headers,
    },
    ...options,
  });

  if (!response.ok) {
    throw new Error(`HTTP error! status: ${response.status}`);
  }

  return response.json();
}

export default fetchData;
