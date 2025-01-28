from image_search import fetch_google_image
from db_utils import fetch_missing_images, update_image

def process_product(product_name):

    image_url = fetch_google_image(product_name)

    if not image_url:
        print(f"No image found for {product_name}")
        return
    
    update_image(product_name, image_url)

def process_missing_image():
    products = fetch_missing_images()
    i = 0
    for product in products:
        process_product(product[2])
        print(("success"), product[2], i)
        i += 1

if __name__ == "__main__":
    process_missing_image()



