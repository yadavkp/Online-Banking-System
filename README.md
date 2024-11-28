
# Online Banking System

 Overview
The Online Banking System is a web-based application that allows users to perform banking transactions and manage their accounts online. This system facilitates various banking activities such as account creation, balance inquiries, fund transfers, transaction history, and more, all from the convenience of a web browser.

**Project Folder Structure**

OnlineBankingSystem/
│
├── src/
│   └── com/
│       └── bank/
│           ├── dao/              
│           │   └── AdminDAO.java   
│           │   └── UserDAO.java 
│           │   └── LoanDAO.java    
│           │
│           ├── model/             
│           │   └── User.java       
│           │   └── LoanAccount.java   
│           │
│           └── main/              
│               └── Admin.java     
│               └── Main.java     
│
├── lib/                          
│   └── mysql-connector-java.jar   
│
└── .vscode/                       
    └── settings.json              
    └── launch.json       


## Features
- **User Registration and Authentication**
  - Secure user registration and login functionality.
  - Password encryption for enhanced security.
- **Account Management**
  - Create and manage multiple accounts.
  - Update user profiles.
- **Transactions**
  - Deposit and withdraw funds.
  - Transfer funds between accounts.
  - View transaction history.
- **Balance Inquiry**
  - Check real-time account balances.
- **User Dashboard**
  - Comprehensive dashboard displaying account summaries and recent transactions.
- **Notifications**
  - Email notifications for important account activities.

## Technologies Used
- **Frontend**
  - HTML, CSS, JavaScript
  - React.js
- **Backend**
  - Node.js
  - Express.js
- **Database**
  - MySQL
- **Authentication**
  - JWT (JSON Web Tokens)
- **Additional Tools**
  - Docker for containerization
  - Git for version control

 # Installation
 # Prerequisites
- Node.js
- MySQL
- Docker (optional, for containerization)

 # Steps
 
1. **Set Up Database**
   - Create a MySQL database:
     ```sql
     CREATE DATABASE online_banking_system;
     ```
   - Update `config/db.js` with your MySQL credentials.

2. **Run Migrations**
   - Use a migration tool or manually create the necessary tables using SQL scripts provided in the `migrations` folder.

 # Database Schema
-      **Users**
       **Accounts**
       **Transactions**
        sql
 

# Usage
1. **Register a New User**: Users can sign up by providing their username, email, and password.
2. **Log In**: Users log in with their credentials to access their account.
3. **Manage Accounts**: Users can create and manage their accounts.
4. **Perform Transactions**: Users can deposit, withdraw, and transfer funds.
5. **Check Balance**: Users can view the current balance of their accounts.
6. **View Transaction History**: Users can see the history of all their transactions.

