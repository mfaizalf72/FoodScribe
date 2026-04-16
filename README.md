# 🍕 FoodScribe - Food Delivery Web App

FoodScribe is a full-stack food delivery web application where users can 
browse food items, place orders, and subscribe to daily meal plans.

---

## 🚀 Features

- 🔐 User Registration & Login
- 🍔 Browse Food Menu by Category
- 🛒 Place Food Orders with Delivery Address
- 📦 Track Order Status
- 📅 Daily Meal Subscription Plans
- 👨‍💼 Admin Dashboard to manage Food, Orders, Users & Subscriptions

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| Backend | Java, Spring Boot |
| Frontend | HTML, CSS, Bootstrap 5 |
| Database | MySQL |
| IDE | IntelliJ IDEA |
| Version Control | Git & GitHub |

---

## 📁 Project Structure
FoodScribe/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── controller/
│   │   │   └── service/
│   │   │   └── repository/
│   │   │   └── entity/
│   │   │   └── dto/
│   │   └── resources/
│   │       └── static/       ← HTML Pages
│   │       └── application.properties
├── pom.xml

---

## ⚙️ How to Run

1. **Clone the project**
```bash
git clone https://github.com/mfaizalf72/FoodScribe.git
```

2. **Configure Database** in `application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/foodscribe
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. **Run the Spring Boot app** in IntelliJ
   - Open project → Run `FoodAppApplication.java`

4. **Open in browser**
   http://localhost:8080

   ---

## 📄 Pages

| Page | Description |
|------|-------------|
| `index.html` | Home Page |
| `menu.html` | Food Menu |
| `subscription.html` | Subscription Plans |
| `orders.html` | My Orders |
| `track.html` | Track Order |
| `admin-dashboard.html` | Admin Panel |

---

## 👨‍💻 Developer

**Mahammad Faizal**  
📧 mfaizalf72@gmail.com  
🔗 [GitHub](https://github.com/mfaizalf72)

---

⭐ If you like this project, give it a star on GitHub!
