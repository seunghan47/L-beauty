from serpapi import GoogleSearch
import requests
from s3_utils import upload_to_s3
from db_utils import get_products_missing_images, update_image_url

# Google Image Search Config
SERPAPI_KEY = "your_serpapi_key"

def fetch_google_image(product_name):
    """Search Google Images and return the first image URL."""
    search = GoogleSearch({
        "q": product_name,      # Query is the product name
        "tbm": "isch",          # Search type is images
        "api_key": SERPAPI_KEY  # SerpAPI Key
    })
    results = search.get_dict()
    if "images_results" in results:
        return results["images_results"][0]["original"]  # Return the first image URL
    return None

def process_missing_images():
    """Fetch missing images and upload to S3."""
    # Get products without images
    products = get_products_missing_images()
    
    for product in products:
        product_name = product["name"]  # Product name for search
        product_id = product["id"]     # Unique product ID
        
        # Search for an image
        image_url = fetch_google_image(product_name)
        if not image_url:
            print(f"No image found for {product_name}")
            continue

        # Download the image
        try:
            image_data = requests.get(image_url).content
        except Exception as e:
            print(f"Failed to download image for {product_name}: {e}")
            continue

        # Upload to S3
        try:
            s3_key = f"product-images/{product_id}.jpg"  # S3 file path
            s3_url = upload_to_s3(s3_key, image_data)
        except Exception as e:
            print(f"Failed to upload to S3 for {product_name}: {e}")
            continue

        # Update database with S3 URL
        update_image_url(product_id, s3_url)
        print(f"Image updated for {product_name} -> {s3_url}")

if __name__ == "__main__":
    process_missing_images()
