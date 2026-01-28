# 🚗 CAR RENTAL SYSTEM - BEGINNER PROJECT

A simple Java console application to manage car rentals with MySQL database.

## 📁 Project Structure

```
CarRentalSystem/
│
├── src/
│   ├── models/
│   │   └── Car.java                  (Car class - represents a car)
│   │
│   ├── database/
│   │   ├── DatabaseConnection.java   (Handles MySQL connection)
│   │   └── CarDAO.java               (Database operations)
│   │
│   └── main/
│       └── CarRentalSystem.java      (Main program - user interface)
│
├── database_setup.sql                (SQL commands to create database)
└── README.md                         (This file)
```

## ✅ Prerequisites

Before running this project, you need:

1. **Java JDK** (version 8 or higher)
2. **MySQL Server** (installed and running)
3. **MySQL JDBC Driver** (mysql-connector-java JAR file)
4. **IDE** (Eclipse, IntelliJ IDEA, or any Java IDE)

## 🔧 Setup Instructions

### Step 1: Database Setup

1. Open MySQL Workbench or MySQL Command Line
2. Run all commands from `database_setup.sql` file
3. This will create:
   - Database: `car_rental_db`
   - Table: `cars`
   - 10 sample cars with Indian plate numbers

### Step 2: Configure Database Connection

1. Open `src/database/DatabaseConnection.java`
2. Update these lines with YOUR MySQL details:
   ```java
   private static final String USERNAME = "root";  // Your MySQL username
   private static final String PASSWORD = "";      // Your MySQL password
   ```

### Step 3: Add MySQL JDBC Driver

**For Eclipse:**
1. Right-click project → Properties
2. Java Build Path → Libraries
3. Add External JARs → Select `mysql-connector-java-x.x.x.jar`

**For IntelliJ IDEA:**
1. File → Project Structure → Libraries
2. Click + → Java
3. Select `mysql-connector-java-x.x.x.jar`

### Step 4: Compile and Run

1. Make sure all files are in correct folders
2. Compile all Java files
3. Run `CarRentalSystem.java` (the main class)

## 🎯 Features

1. **View Available Cars** - Filter by category (SUV, Sedan, Hatchback)
2. **Rent a Car** - Change car status from Available to Rented
3. **Return Car & Get Bill** - Calculate rental cost and update status
4. **Currency** - All rates are in Indian Rupees (₹)

## 📝 Sample Car Data

The database includes 10 sample cars:

| Plate No    | Model               | Category   | Rate/Day |
|-------------|---------------------|------------|----------|
| MH01AB1234  | Maruti Suzuki Brezza| SUV        | ₹2500    |
| MH02CD5678  | Hyundai Creta       | SUV        | ₹3000    |
| DL03EF9012  | Honda City          | Sedan      | ₹2000    |
| KA04GH3456  | Maruti Suzuki Dzire | Sedan      | ₹1800    |
| TN05IJ7890  | Hyundai i20         | Hatchback  | ₹1500    |
| ... and more

## 💡 How It Works

### Rent a Car:
1. Select "Rent a Car" from menu
2. Enter plate number (e.g., MH01AB1234)
3. Confirm rental
4. Car status changes to "Rented"

### Return a Car:
1. Select "Return Car & Get Bill"
2. Enter plate number
3. Enter number of days rented
4. **Bill Calculation:** Total = Days × Rate per Day
5. Bill is displayed
6. Car status changes back to "Available"

### Example Bill:
```
========================================
          RENTAL BILL
========================================
Car Model: Hyundai Creta
Plate Number: MH02CD5678
Category: SUV
----------------------------------------
Rate per Day: ₹3000.0
Number of Days: 5
----------------------------------------
TOTAL BILL: ₹15000.0
========================================
```

## 🎓 Key Concepts Covered (Beginner-Friendly)

1. **Classes and Objects** - Car class represents real-world entity
2. **Database Connection** - JDBC to connect Java with MySQL
3. **SQL Queries** - SELECT, UPDATE with WHERE clause
4. **Data Filtering** - Filter cars by category
5. **Mathematical Logic** - Bill = Days × Rate
6. **User Input** - Scanner for console input
7. **Error Handling** - Try-catch blocks
8. **Code Organization** - Separate files for different purposes

## ⚠️ Common Issues & Solutions

**Problem:** "ClassNotFoundException: com.mysql.cj.jdbc.Driver"
- **Solution:** Add MySQL JDBC Driver JAR to project

**Problem:** "SQLException: Access denied for user"
- **Solution:** Check username and password in DatabaseConnection.java

**Problem:** "Database 'car_rental_db' doesn't exist"
- **Solution:** Run the database_setup.sql file first

**Problem:** No cars showing up
- **Solution:** Check if sample data was inserted (run SELECT * FROM cars;)

## 📚 Learning Tips

- Read the comments in each file - they explain what each part does
- Try adding more features (e.g., search by plate number)
- Experiment with different SQL queries
- Add more sample cars to the database
- Try changing the rental rates

## 🎉 Next Steps to Improve

Once comfortable with this project, try:
1. Add customer information table
2. Track rental history
3. Add late fees calculation
4. Create a GUI using Java Swing
5. Add date tracking for rentals

---

**Happy Coding! 🚀**

If you face any issues, check:
1. MySQL is running
2. Database is created
3. JDBC driver is added
4. Username/password are correct
