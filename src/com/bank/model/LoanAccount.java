package com.bank.model;

public class LoanAccount {
    private int loanAccountId;
    private double loanAmount;
    private boolean approved;

    public LoanAccount(int loanAccountId, double loanAmount, boolean approved) {
        this.loanAccountId = loanAccountId;
        this.loanAmount = loanAmount;
        this.approved = approved;
    }

    // Getters and setters
    public int getLoanAccountId() {
        return loanAccountId;
    }

    public void setLoanAccountId(int loanAccountId) {
        this.loanAccountId = loanAccountId;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}

