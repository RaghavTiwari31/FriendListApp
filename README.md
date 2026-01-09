# 👥 Friend List App (Java Swing + Terminal)

![Java](https://img.shields.io/badge/Java-JDK%208%2B-orange)
![Swing](https://img.shields.io/badge/GUI-Java%20Swing-blue)
![CLI](https://img.shields.io/badge/Mode-Terminal%20%26%20GUI-success)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)
![Project](https://img.shields.io/badge/Type-College%20Project-purple)

---

## 📌 Overview

**Friend List App** is a Java-based application that allows users to **securely manage a personal list of friends**.  
It supports both **terminal-based interaction** and a **graphical user interface (Java Swing)**, making it suitable for learning core Java concepts as well as basic GUI development.

The application uses **file-based persistence**, ensuring that each user's data is stored locally and loaded automatically on login.

---

## ✨ Features

### 🔐 Authentication
- User login with password verification  
- User-specific data storage  

### 📇 Friend Management
- ➕ Add new friends (Name, Contact, Address, DOB)
- 🔁 Update existing friend details
- ❌ Delete friends from the list
- 📜 Display all friends in a scrollable view

### 🖥️ Dual Mode Support
- **Terminal Mode** – menu-driven CLI
- **GUI Mode** – Java Swing-based interface

### 💾 Data Persistence
- Stores friend data in user-specific `.txt` files  
- Configuration handled via `.properties` files  

---

## 🛠️ Tech Stack

- **Java (JDK 8+)**
- **Java Swing** – GUI
- **File I/O** – Data persistence
- **OOP Principles** – Encapsulation, modular design
- **Properties API** – Configuration management

---

## 📂 Directory Structure

```text
FriendListApp/
│
├── config/                 # Configuration (.properties) files
│
├── data/                   # User-specific data files
│   └── FriendList_<username>.txt
│
├── gui/                    # Swing GUI components
│   ├── LoginGUI.java
│   └── MainMenuGUI.java
│
├── model/                  # Data models
│   └── Friend.java
│
├── service/                # Business logic & file handling
│   └── FriendService.java
│
├── Main.java                # Application entry point
└── README.md
```

## ▶️ How to Run
### 1️⃣ Compile the Project
```bash
javac Main.java
```

### 2️⃣ Run the Application
```bash
java Main
```

### 3️⃣ Choose Mode
- Use Terminal Mode for CLI interaction
- Launch GUI Mode for Swing-based interface

## 📈 Learning Outcomes

- Java File Handling & Persistence
- Object-Oriented Design in Java
- Java Swing GUI fundamentals
- Separation of concerns (Model / Service / GUI)
- Real-world menu-driven application flow

## 🔮 Possible Enhancements

- Password hashing instead of plain-text storage
- Search & filter friends
- Export friend list as CSV
- Database integration (MySQL / SQLite)
- Improved GUI styling

## 👤 Author

- **Raghav Tiwari**
- B.Tech Computer Science Engineering
- Java | Software Engineering | Backend
