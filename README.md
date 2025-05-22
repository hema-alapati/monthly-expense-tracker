# 💰 Expense Tracker Backend

A Spring Boot + MySQL backend REST API application that helps users track their **income**, **expenses**, and compute the **remaining balance**. This backend is designed for integration with a frontend (mobile or web) and offers full CRUD operations for users, incomes, and expenses.

---

## 🚀 Features

* Full **CRUD APIs** for Users, Incomes, and Expenses
* Track and categorize **income** and **expenses**
* Retrieve **remaining balance** per user
* RESTful API architecture
* Designed with **Spring Boot**, **Spring Data JPA**, and **MySQL**

---

## 🧩 Technologies Used

* **Java 21**
* **Spring Boot**
* **Spring Data JPA**
* **MySQL**
* **Lombok**
* **Maven**

---

## 📦 API Endpoints

### 1. 👤 User Management Endpoints

| Method | Endpoint          | Description       |
| ------ | ----------------- | ----------------- |
| GET    | `/api/users`      | Get all users     |
| GET    | `/api/users/{id}` | Get user by ID    |
| POST   | `/api/users`      | Create a new user |
| PUT    | `/api/users/{id}` | Update user by ID |
| DELETE | `/api/users/{id}` | Delete user by ID |

---

### 2. 💵 Income Management Endpoints

| Method | Endpoint                    | Description             |
| ------ | --------------------------- | ----------------------- |
| GET    | `/api/income/user/{userId}` | Get all incomes of user |
| POST   | `/api/income/add`           | Add a new income        |
| PUT    | `/api/income/{id}`          | Update income by ID     |
| DELETE | `/api/income/{id}`          | Delete income by ID     |

---

### 3. 🧾 Expense Management Endpoints

| Method | Endpoint                     | Description              |
| ------ | ---------------------------- | ------------------------ |
| GET    | `/api/expense/user/{userId}` | Get all expenses of user |
| POST   | `/api/expense/add`           | Add a new expense        |
| PUT    | `/api/expense/{id}`          | Update expense by ID     |
| DELETE | `/api/expense/{id}`          | Delete expense by ID     |

---

### 4. 🧮 Balance Summary Endpoint

| Method | Endpoint                     | Description                                                        |
| ------ | ---------------------------- | ------------------------------------------------------------------ |
| GET    | `/api/balance/user/{userId}` | Get remaining balance (Total Income - Total Expenses) for the user |

---

## 🧠 Data Models

### 1. **User Model**

| Field      | Type   | Description                         |
| ---------- | ------ | ----------------------------------- |
| `id`       | Long   | Unique user ID                      |
| `name`     | String | Full name of the user               |
| `email`    | String | Unique email (required)             |
| `password` | String | Plaintext password (no hashing yet) |

---

### 2. **Income Model**

| Field          | Type   | Description                                   |
| -------------- | ------ | --------------------------------------------- |
| `id`           | Long   | Unique income ID                              |
| `amount`       | Double | Income amount                                 |
| `description`  | String | Description of the income                     |
| `categoryName` | String | Income category (e.g., "Salary", "Freelance") |
| `user`         | User   | Linked user object                            |

---

### 3. **Expense Model**

| Field          | Type   | Description                                  |
| -------------- | ------ | -------------------------------------------- |
| `id`           | Long   | Unique expense ID                            |
| `amount`       | Double | Expense amount                               |
| `description`  | String | Description of the expense                   |
| `categoryName` | String | Expense category (e.g., "Food", "Transport") |
| `user`         | User   | Linked user object                           |

---

## 🛠️ Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/expense-tracker-backend.git
cd expense-tracker-backend
```

### 2. Configure MySQL Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Build and Run

```bash
mvn clean install
mvn spring-boot:run
```

---

## 🔐 Notes

* **Authentication/Authorization** is **not implemented** yet. All endpoints are publicly accessible for now.
* Passwords are stored as **plain text** (insecure) — hashing will be added in future updates.

---

## 🧪 Future Improvements

* JWT-based Authentication & Authorization
* Password hashing (BCrypt)
* Pagination for income/expense listings
* Filtering by date/category
* Swagger/OpenAPI Documentation
* Docker containerization

---

## 🤝 Contributing

Pull requests are welcome! Please open an issue first to discuss major changes.

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).

---
