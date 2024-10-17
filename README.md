# lbeauty - E-commerce Project

Welcome to the **lbeauty** e-commerce project! This is a full-stack web application designed to allow customers to browse and order beauty products and services online. The project utilizes modern web technologies and cloud services to provide a seamless shopping experience.

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Features
- Browse a wide range of beauty products and services.
- Search for specific products and view detailed descriptions.
- Customer recommendations for new products.
- Responsive design for optimal viewing on various devices.
- Integration with a MySQL database for data persistence.
- Image fetching from Google to display product images.

## Technologies Used
- **Frontend**: React
- **Backend**: Java, Spring Boot
- **Database**: MySQL
- **Cloud Services**: AWS (S3 for static hosting, CloudFront for CDN)
- **Containerization**: Docker

## Project Structure
/Users/polim/Desktop/personalProject/freelancing/e-commerce/lbeauty │ ├── frontend/ # React application │ ├── src/ # Source code │ └── public/ # Public assets │ └── backend/ # Spring Boot application ├── src/ # Source code └── resources/ # Configuration files


## Setup and Installation
To get started with the project locally, first clone the repository from GitHub using the command `git clone https://github.com/yourusername/lbeauty.git`, and navigate to the cloned directory. Set up the backend by navigating to the `backend` directory, updating the database configuration in `application.properties` to connect to your MySQL database, and running the Spring Boot application with `./mvnw spring-boot:run`. Then, set up the frontend by navigating to the `frontend` directory, installing the necessary dependencies with `npm install`, and starting the React application with `npm start`. Once everything is running, open your browser and go to `http://localhost:3000` to view the application.

## Usage
- Browse through the available beauty products and services.
- Use the search feature to find specific products.
- View detailed information and make recommendations.
- Products are dynamically fetched and displayed, including images sourced from Google.

## Contributing
Contributions are welcome! If you have suggestions for improvements or want to report a bug, please open an issue or submit a pull request.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more information.

## Contact
For inquiries, please contact:
- Your Name - [your.email@example.com](mailto:your.email@example.com)
- GitHub: [yourusername](https://github.com/yourusername)

Thank you for checking out **lbeauty**!
