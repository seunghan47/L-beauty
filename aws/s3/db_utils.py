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

    query = "SELECT id, name, UPC FROM inventory WHERE image_url IS NULL LIMIT 100"
    cursor = conn.cursor()
    cursor.execute(query)
    results = cursor.fetchall()
    conn.close()
    return results

def update_image(product_id, image_url):
    try:
        conn = mysql.connector.connect(
            host=DB_HOST,
            user=DB_USER,
            password=DB_PASSWORD,
            database=DB_NAME
        )
    except mysql.connector.Error as err:
        print(f"Error: {err}")

    query = "UPDATE your_table SET image = %s WHERE id = %s"
    cursor = conn.cursor()
    cursor.execute(query, (image_url, product_id))
    conn.commit()
    conn.close()

if __name__ == "__main__":
    result = fetch_missing_images()
    for row in result:
        print(row)