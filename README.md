<div align="center">

<br>

```
 ██████╗ ███╗   ██╗██╗     ██╗███╗   ██╗███████╗    ███████╗███████╗███╗   ██╗██████╗ ███████╗██████╗ 
██╔═══██╗████╗  ██║██║     ██║████╗  ██║██╔════╝    ██╔════╝██╔════╝████╗  ██║██╔══██╗██╔════╝██╔══██╗
██║   ██║██╔██╗ ██║██║     ██║██╔██╗ ██║█████╗      ███████╗█████╗  ██╔██╗ ██║██║  ██║█████╗  ██████╔╝
██║   ██║██║╚██╗██║██║     ██║██║╚██╗██║██╔══╝      ╚════██║██╔══╝  ██║╚██╗██║██║  ██║██╔══╝  ██╔══██╗
╚██████╔╝██║ ╚████║███████╗██║██║ ╚████║███████╗    ███████║███████╗██║ ╚████║██████╔╝███████╗██║  ██║
 ╚═════╝ ╚═╝  ╚═══╝╚══════╝╚═╝╚═╝  ╚═══╝╚══════╝    ╚══════╝╚══════╝╚═╝  ╚═══╝╚═════╝ ╚══════╝╚═╝  ╚═╝
```

### Share text instantly — no login, no hassle, just a code.

<br>

[![Java](https://img.shields.io/badge/Java_17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot_3-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![Render](https://img.shields.io/badge/Deployed_on-Render-46E3B7?style=for-the-badge&logo=render&logoColor=white)](https://render.com/)
[![Status](https://img.shields.io/badge/Status-Live_🟢-success?style=for-the-badge)]()

<br>

## 🌐 [online-sender-2.onrender.com](https://online-sender-2.onrender.com)

*Built with ❤️ by **Mohd Shan Choudhary***

<br>

---

</div>

## 📌 What is Online Sender?

**Online Sender** is a lightweight, blazing-fast web app that lets you share any text — notes, code, links, messages — using a simple **6-character code**. No accounts. No tracking. No friction.

Paste your text → Generate a code → Share it. That's it.

```
You  ──► [Paste Text]  ──► [Generate Code: A3X9K2]  ──► Share code
                                                              │
Anyone  ◄─── [Retrieve Text] ◄─── [Enter Code: A3X9K2] ◄────┘
```

<br>

---

## ✨ Features

| Feature | Details |
|---|---|
| ⚡ Instant sharing | Generate a code in milliseconds |
| 🔑 6-character codes | Short, memorable, easy to share |
| ⏰ Auto-expiry | Content deletes automatically (default: 24 hours) |
| 👁️ View counter | Track how many times content was retrieved |
| 🚫 No auth required | Zero sign-up friction |
| 📱 Responsive UI | Works on mobile, tablet, and desktop |
| 🔌 REST API | Integrate with your own tools |
| 🛡️ Production-ready | Deployed on Render with PostgreSQL |

<br>

---

## 🛠️ Tech Stack

<table>
<tr>
<td width="33%" valign="top">

### 🖥️ Backend
- **Java 17**
- **Spring Boot 3.2**
- **Spring Data JPA**
- **Spring Validation**

</td>
<td width="33%" valign="top">

### 🗄️ Database
- **PostgreSQL** (Production)
- **H2** (Local dev)

</td>
<td width="33%" valign="top">

### 🎨 Frontend
- **HTML5**
- **CSS3**
- **Vanilla JavaScript**

</td>
</tr>
<tr>
<td colspan="3" valign="top">

### ⚙️ DevOps
- **Maven** — Build tool
- **Git & GitHub** — Version control
- **Render** — Cloud hosting & managed PostgreSQL

</td>
</tr>
</table>

<br>

---

## 🔌 API Reference

### ➕ Create Clipboard

```http
POST /api/clipboard
Content-Type: application/json
```

**Request Body:**
```json
{
  "content": "Your text here",
  "expiryHours": 24
}
```

**Response:**
```json
{
  "code": "A3X9K2",
  "message": "Clipboard created successfully",
  "expiresAt": "2026-04-15T09:00:00Z"
}
```

---

### 📥 Retrieve Clipboard

```http
GET /api/clipboard/{code}
```

**Response:**
```json
{
  "content": "Your text here",
  "viewCount": 3,
  "expiresAt": "2026-04-15T09:00:00Z"
}
```

---

### ❤️ Health Check

```http
GET /api/clipboard/health
```

**Response:**
```json
{
  "service": "Online Sender by Shan",
  "version": "1.0.0",
  "status": "UP"
}
```

<br>

---

## 📁 Project Structure

```
Online-Sender/
│
├── 📂 src/main/java/com/shan/onlinesender/
│   ├── 📂 controller/        ← REST API endpoints
│   ├── 📂 service/           ← Business logic
│   ├── 📂 repository/        ← Database queries (JPA)
│   └── 📂 model/             ← Entity definitions
│
├── 📂 src/main/resources/
│   ├── 📄 application.properties   ← App configuration
│   └── 📂 static/
│       └── 📄 index.html     ← Frontend UI
│
├── 📄 pom.xml                ← Maven dependencies
└── 📄 README.md
```

<br>

---

## ▶️ Run Locally

### Prerequisites

- ☕ Java 17+
- 📦 Maven
- 🐙 Git

### Steps

```bash
# 1. Clone the repository
git clone https://github.com/MohdShanChoudhary/Online-Sender.git

# 2. Navigate into the project
cd Online-Sender

# 3. Run with Maven (uses H2 in-memory DB locally)
./mvnw spring-boot:run

# 4. Open in browser
open http://localhost:8080
```

> **Note:** Locally, the app uses **H2 in-memory database** — no setup needed. For production PostgreSQL, configure `application.properties` with your DB credentials.

<br>

---

## ☁️ Deployment (Render)

The app is deployed on **[Render](https://render.com)** with these settings:

| Setting | Value |
|---|---|
| Platform | Render Web Service |
| Database | Render PostgreSQL |
| Auto-deploy | ✅ On every `git push` |
| Region | Singapore |
| Build Command | `./mvnw clean package -DskipTests` |
| Start Command | `java -jar target/online-sender.jar` |

### Environment Variables (Render Dashboard)

```
DATABASE_URL    =  jdbc:postgresql://<host>:5432/<dbname>
DB_USERNAME     =  your_db_username
DB_PASSWORD     =  your_db_password
```

<br>

---

## 🚀 Roadmap

- [x] Core send & retrieve functionality
- [x] Auto-expiry system
- [x] View counter
- [x] Production deployment on Render
- [ ] 🔐 Password-protected messages
- [ ] 📊 Analytics dashboard
- [ ] 🚦 Rate limiting & abuse prevention
- [ ] 📎 File sharing support
- [ ] 🌙 Dark / Light mode toggle

<br>

---

## 👨‍💻 Developer

<div align="center">

### Mohd Shan Choudhary

[![GitHub](https://img.shields.io/badge/GitHub-MohdShanChoudhary-181717?style=for-the-badge&logo=github)](https://github.com/MohdShanChoudhary)
[![Repo](https://img.shields.io/badge/Repository-Online--Sender-blue?style=for-the-badge&logo=github)](https://github.com/MohdShanChoudhary/Online-Sender)

*If you found this useful, drop a ⭐ on the repo — it means a lot!*

</div>

<br>

---

<div align="center">

**Made with ☕ Java & 💜 passion**

*© 2026 Mohd Shan Choudhary — Online Sender*

</div>
