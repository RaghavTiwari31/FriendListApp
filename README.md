# Friend List App (Java Swing + Terminal Based)

A Java-based application that allows users to manage a personal friend list with features like login authentication, adding, updating, deleting, and displaying friend details.

## 💻 Features

- 🔐 User login with password verification
- ➕ Add new friends with name, contact, address, and DOB
- 🔁 Update existing friend details
- ❌ Delete friends from the list
- 📜 Display all friends in a scrollable dialog
- 🖥️ Available in both GUI (Java Swing) and terminal modes
- 🛠️ Stores user-specific data in `.txt` files
- ⚙️ Configurations managed through `.properties` files

## 📂 Directory Structure

FriendListApp/
├── config/ # Contains configuration .properties files
├── data/ # Stores user-specific FriendList_<username>.txt files
├── gui/ # Swing GUI components (LoginGUI, MainMenuGUI)
├── model/ # Friend.java model class
├── service/ # FriendService.java handles logic & file ops
├── Main.java # Entry point of the application
└── README.md