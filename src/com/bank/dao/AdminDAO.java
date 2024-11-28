package com.bank.dao;

import com.bank.model.User;
import com.bank.model.LoanAccount;

import java.sql.*;

public class AdminDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/online_banking_system";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";

    // Database connection method
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Insert a new user
    public void insertUser(User user) {
        String sql = "INSERT INTO users (username, password, first_name, last_name, email) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete user by ID
    public boolean deleteUser(int userId) {
        String sql = "DELETE FROM users WHERE user_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userId);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Block user by ID
    public boolean blockUser(int userId) {
        String sql = "UPDATE users SET status = 'blocked' WHERE user_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userId);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get loan account by ID
    public LoanAccount getLoanAccountById(int loanAccountId) {
        String sql = "SELECT * FROM loan_accounts WHERE loan_account_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, loanAccountId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("loan_account_id");
                double amount = resultSet.getDouble("loan_amount");
                boolean approved = resultSet.getBoolean("approved");
                return new LoanAccount(id, amount, approved);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update loan account status
    public void updateLoanAccount(LoanAccount loanAccount) {
        String sql = "UPDATE loan_accounts SET approved = ? WHERE loan_account_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setBoolean(1, loanAccount.isApproved());
            preparedStatement.setInt(2, loanAccount.getLoanAccountId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
