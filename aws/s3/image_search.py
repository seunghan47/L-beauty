import requests
from config import API_KEY, SEARCH_ENGINE_ID

def fetch_google_image(product_name):
    url = "https://www.googleapis.com/customsearch/v1"
    params = {
        "q": product_name,        
        "cx": SEARCH_ENGINE_ID,   
        "key": API_KEY,           
        "searchType": "image",    
        "num": 1                  
    }

    try: 
        response = requests.get(url, params=params)
        response.raise_for_status()

        data = response.json()
        if "items" in data:
            return data["items"][0]["link"]  # First image URL
        else:
            print(f"No images found for: {product_name}")
            return None
    except Exception as e:
        print(f"Error fetching image for {product_name}: {e}")
        return None
    
if __name__ == "__main__":
    product_name = "pachinko"
    image_url = fetch_google_image(product_name)
    if image_url:
        print(f"Found image for '{product_name}': {image_url}")
    else:
        print(f"No image found for '{product_name}'.")
    