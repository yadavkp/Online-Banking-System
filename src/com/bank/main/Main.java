package com.bank.main;

import com.bank.dao.AdminDAO;
import com.bank.model.User;
import com.bank.model.LoanAccount;

public class Main {
    public static void main(String[] args) {
         
        
        // Open Account Example
        User user = new User("john_doe", "password123", "John", "Doe", "john.doe@example.com");
        Admin.openAccount(user);

        // Delete Account Example
        Admin.deleteAccount(1);   

        // Block Account Example
        Admin.blockAccount(2);   

        // Approve Loan Example
        Admin.approveLoan(101);  
    }
}


