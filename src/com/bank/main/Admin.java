package com.bank.main;

import com.bank.dao.AdminDAO;
import com.bank.model.User;
import com.bank.model.LoanAccount;

public class Admin {

    public static void openAccount(User user) {
        AdminDAO adminDAO = new AdminDAO();
        adminDAO.insertUser(user);
        System.out.println("Account opened successfully for: " + user.getUsername());
    }

    public static void deleteAccount(int userId) {
        AdminDAO adminDAO = new AdminDAO();
        boolean result = adminDAO.deleteUser(userId);
        if (result) {
            System.out.println("Account deleted successfully for user ID: " + userId);
        } else {
            System.out.println("Error deleting account.");
        }
    }

    public static void blockAccount(int userId) {
        AdminDAO adminDAO = new AdminDAO();
        boolean result = adminDAO.blockUser(userId);
        if (result) {
            System.out.println("Account blocked successfully for user ID: " + userId);
        } else {
            System.out.println("Error blocking account.");
        }
    }

    public static void approveLoan(int loanAccountId) {
        AdminDAO adminDAO = new AdminDAO();
        LoanAccount loanAccount = adminDAO.getLoanAccountById(loanAccountId);
        if (loanAccount != null) {
            loanAccount.setApproved(true);
            adminDAO.updateLoanAccount(loanAccount);
            System.out.println("Loan account approved: " + loanAccountId);
        } else {
            System.out.println("Loan account not found.");
        }
    }
}
