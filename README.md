<div align="center">

# 📋 Online Sender  

### 🚀 Share text instantly with anyone, anywhere  

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green?style=for-the-badge&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue?style=for-the-badge&logo=postgresql)
![Railway](https://img.shields.io/badge/Deployed%20On-Railway-purple?style=for-the-badge&logo=railway)
![Status](https://img.shields.io/badge/Status-Live-success?style=for-the-badge)

🌐 **Live App**  
👉 https://online-sender-text.up.railway.app/

Developed by **Shan**

</div>

---

## ✨ What is Online Sender?

**Online Sender** is a fast, minimal, and secure web application that allows users to share text using a **short unique code**.  
No login. No signup. Just paste → generate → share.

Perfect for:
- Sharing notes
- Code snippets
- Temporary messages
- Quick text transfer between devices

---

## 🔥 Features

✅ Generate unique 6-character codes  
✅ Retrieve content instantly using the code  
✅ Auto-expiry (default: 24 hours)  
✅ View counter for each message  
✅ No authentication required  
✅ RESTful API  
✅ Responsive UI  
✅ Production-ready backend  

---

## 🧠 How It Works

User → Paste Text
↓
Backend generates code
↓
Text stored in PostgreSQL
↓
Code shared with others
↓
Anyone retrieves text using the code


---

## 🛠️ Tech Stack

### Backend
- Java 17  
- Spring Boot 3  
- Spring Data JPA  
- PostgreSQL (Production)  
- H2 Database (Local)  

### Frontend
- HTML5  
- CSS3  
- Vanilla JavaScript  

### DevOps & Tools
- Maven  
- Git & GitHub  
- Railway Cloud  

---

## 🔌 API Endpoints

### ➕ Create Clipboard
```http
POST /api/clipboard
Content-Type: application/json

{
  "content": "Hello World",
  "expiryHours": 24
}

📥 Retrieve Clipboard
GET /api/clipboard/{code}

❤️ Health Check
GET /api/clipboard/health

{
  "service": "Online Sender by Shan",
  "version": "1.0.0",
  "status": "UP"
}

📁 Project Structure
Online-Sender/
├── src/main/java/com/shan/onlinesender
│   ├── controller/
│   ├── service/
│   ├── repository/
│   └── model/
├── src/main/resources
│   └── static/index.html
├── pom.xml
└── README.md

▶️ Run Locally
Prerequisites

Java 17+

Maven

Git

Steps
git clone https://github.com/MohdShanChoudhary/Online-Sender.git
cd Online-Sender
./mvnw spring-boot:run


Open:

http://localhost:8080

☁️ Deployment

Hosted on Railway

PostgreSQL managed by Railway

Auto-deploy enabled on every Git push

📌 Just push code → app updates automatically

🚀 Future Improvements

🔐 Password-protected messages

📊 Analytics dashboard

🚦 Rate limiting



👨‍💻 Developer
Mohd Shan 

GitHub: https://github.com/MohdShanChoudhary

Repository: https://github.com/MohdShanChoudhary/Online-Sender
