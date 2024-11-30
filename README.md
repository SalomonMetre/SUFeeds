# SU Feeds  

## Overview  
**SU Feeds** is a Java desktop application built using **Java Swing** and **JDBC**. It is designed to help students save and manage the classes they are attending, add topics learned weekly, and upload feedback, comments, jokes, or summaries about the topics for other students to view.   


## Features  
### Functional Requirements  
1. **Student Account Management**  
   - Students can create and manage their accounts to save classes for the current semester.  

2. **Weekly Topic Management**  
   - Students can add topics they have learned for each class on a weekly basis.  

3. **Feedback System**  
   - Students can upload feedback, comments, jokes, or summaries about the weekly topics.  
   - Feedback is visible to all users of the application.  

### Non-Functional Requirements  
1. **User-Friendly GUI**  
   - Intuitive design using **Java Swing** for a smooth user experience.  

2. **Error Handling**  
   - Provides clear clarifications or warnings in case of user input errors.  
   - Ensures the application does not crash due to invalid inputs.  

3. **Password Security**  
   - User passwords are hashed using **SHA-256** before being stored in the database.  
   - Enhances data security by ensuring that plaintext passwords are never stored.   

---

## Technologies Used  
- **Java Swing**: For building the graphical user interface.  
- **JDBC**: For connecting and interacting with the database.  
- **MySQL**: Database used to store student accounts, classes, topics, and feedback.  
- **SHA-256**: Used for password hashing.  

---

## Database Details  
- **Database Name**: `sufeeds_db`  
- **Tables**:  
  - `tbl_students`: Stores student account information (hashed passwords).  
  - `tbl_classes`: Stores class details for the semester.  
  - `tbl_topics`: Stores topics learned weekly.  
  - `tbl_feedback`: Stores feedback/comments/jokes/summaries uploaded by students.  

---

## Installation and Setup  
1. Clone this repository:  
   ```bash  
   git clone https://github.com/SalomonMetre/SUFeeds  
   ```  
2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).  
3. Set up the database:  
   - Import the `sufeeds_db.sql` file into your MySQL server.  
4. Update the database connection credentials in the Java code:  
   ```java  
   String url = "jdbc:mysql://localhost:3306/sufeeds_db";  
   String username = "<your-db-username>";  
   String password = "<your-db-password>";  
   ```  
5. Compile and run the application.  

---

## How Password Security Works  
- **Password Hashing**: When a student creates an account or updates their password, the application hashes the password using **SHA-256** before storing it in the database.  
- **Validation**: During login, the application hashes the entered password and compares it to the stored hashed password for verification.  

---

## How to Use  
1. **Create an Account**  
   - Enter your details and save your classes for the semester.  

2. **Add Weekly Topics**  
   - Select a class and add the topics you have learned for a specific week.  

3. **Upload Feedback**  
   - Share feedback, comments, jokes, or summaries on topics.  
   - View feedback uploaded by other students.  

---


## License  
This project is developed for educational purposes only to illustrate fundamental OOP principles, GUI basics, and JDBC. <br>
Salomon Kulondwa Metre, 2024 

---
