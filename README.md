# 💄 LBeauty — Full-Stack E-Commerce Platform

A production-grade full-stack web application built for a local retail beauty supply store, enabling online product browsing, inventory management, and order workflows. Deployed on AWS with a secure, scalable cloud architecture.

---

## 🏗️ Architecture

```
                        ┌─────────────┐
                        │   Route 53  │  DNS Routing
                        └──────┬──────┘
                               │
                        ┌──────▼──────┐
                        │  CloudFront │  CDN
                        └──────┬──────┘
                               │
              ┌────────────────┼────────────────┐
              │                │                │
       ┌──────▼──────┐  ┌──────▼──────┐  ┌──────▼──────┐
       │     S3      │  │    EC2      │  │    RDS      │
       │  (React UI) │  │ (Spring     │  │  (MySQL)    │
       │             │  │  Boot API)  │  │             │
       └─────────────┘  └─────────────┘  └─────────────┘
                               │
                        ┌──────▼──────┐
                        │    IAM      │  Cross-service Auth
                        └─────────────┘
```

---

## ✨ Features

- Browse and search beauty products with dynamic filtering
- Product detail pages with descriptions and images
- Customer product recommendations
- Inventory tracking and order workflow automation
- Responsive design for mobile and desktop
- Secure cross-service authentication via IAM roles

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| Frontend | React, HTML/CSS |
| Backend | Java, Spring Boot, REST APIs |
| Database | MySQL (AWS RDS) |
| Cloud | AWS EC2, S3, RDS, CloudFront, Route 53, IAM |
| Containerization | Docker |

---

## 🚀 Running Locally

### Prerequisites
- Java 17+
- Node.js 18+
- MySQL or Docker

### Option 1 — Docker Compose (Recommended)
```bash
git clone https://github.com/seunghan47/lbeauty.git
cd lbeauty
docker-compose up
```
App runs at `http://localhost:3000`

### Option 2 — Manual Setup

**Backend:**
```bash
cd backend
# Update src/main/resources/application.properties with your DB credentials
./mvnw spring-boot:run
```

**Frontend:**
```bash
cd frontend
npm install
npm start
```

---

## ☁️ AWS Deployment Architecture

| Service | Purpose |
|---------|---------|
| EC2 | Hosts the Spring Boot backend API |
| S3 | Hosts the static React frontend |
| RDS | Managed MySQL database |
| CloudFront | CDN for low-latency static asset delivery |
| Route 53 | DNS routing to CloudFront and EC2 |
| IAM | Role-based cross-service authentication |

---

## 📡 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/products` | Fetch all products |
| GET | `/api/products/{id}` | Fetch product by ID |
| GET | `/api/products/search?q=` | Search products |
| POST | `/api/orders` | Create new order |
| GET | `/api/inventory` | Get inventory status |

---

## 📁 Project Structure

```
lbeauty/
├── backend/
│   ├── src/main/java/
│   │   ├── controller/     # REST API controllers
│   │   ├── service/        # Business logic
│   │   ├── model/          # Entity classes
│   │   └── repository/     # JPA repositories
│   └── src/main/resources/
│       └── application.properties
├── frontend/
│   ├── src/
│   │   ├── components/     # React components
│   │   ├── pages/          # Page views
│   │   └── services/       # API calls
│   └── public/
└── docker-compose.yml
```

---

## 📬 Contact

**Paul Lim**
- Email: paulslim47@gmail.com
- GitHub: [@seunghan47](https://github.com/seunghan47)
- LinkedIn: [Paul Lim](https://linkedin.com/in/yourprofile)
