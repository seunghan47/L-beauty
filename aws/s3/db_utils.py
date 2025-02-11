import mysql.connector
from config_local import DB_HOST, DB_NAME, DB_PASSWORD, DB_USER

def fetch_missing_images():

    try:
        conn = mysql.connector.connect(
            host=DB_HOST,
            user=DB_USER,
            password=DB_PASSWORD,
            database=DB_NAME
        )
    except mysql.connector.Error as err:
        print(f"Error: {err}")

    query = "SELECT * FROM inventory WHERE image_url IS NULL LIMIT 100"
    cursor = conn.cursor()
    cursor.execute(query)
    results = cursor.fetchall()
    conn.close()
    return results

'''
    takes in product id, and image url and put the image url into respective product id

'''
def update_image(product_name, image_url):
    try:
        conn = mysql.connector.connect(
            host=DB_HOST,
            user=DB_USER,
            password=DB_PASSWORD,
            database=DB_NAME
        )
    except mysql.connector.Error as err:
        print(f"Error: {err}")

    query = "UPDATE inventory SET image_url = %s WHERE name = %s"
    cursor = conn.cursor()
    cursor.execute(query, (image_url, product_name))
    print(f"{product_name} updated with {image_url}")
    conn.commit()
    conn.close()

def updated_images():
    try:
        conn = mysql.connector.connect(
            host=DB_HOST,
            user=DB_USER,
            password=DB_PASSWORD,
            database=DB_NAME
        )
    except mysql.connector.Error as err:
        print(f"Error: {err}")
    
    query = "SELECT * FROM inventory WHERE image_url IS NOT null"
    cursor = conn.cursor()
    cursor.execute(query)
    results = cursor.fetchall()
    conn.close()
    return results



if __name__ == "__main__":
    result = fetch_missing_images()
    result = updated_images()
    print("running db_utils")
    for row in result:
        print(row[2])