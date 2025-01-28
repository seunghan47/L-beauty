import mysql.connector
from config_local import DB_HOST, DB_USER, DB_PASSWORD, DB_NAME
import boto3

def get_missing_image():

    try:
        conn = mysql.connector.connect(
            host=DB_HOST,
            user=DB_USER,
            password=DB_PASSWORD,
            database=DB_NAME
        )
    except mysql.connector.Error as err:
        print(f"Error: {err}")

    
    cursor = conn.cursor()
    query = "SELECT * FROM inventory LIMIT 10;"
    cursor.execute(query)
    results = cursor.fetchall()
    cursor.close()
    conn.close()
    return results
   
if __name__ == "__main__":
    results = get_missing_image()
    for row in results:
        print(row)
