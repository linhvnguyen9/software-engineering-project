package com.e17cn2.dormitorymanagement.model;

public class DebtStatDTO {
    private String debtName;
    private double amount;

    public DebtStatDTO() {
    }

    public DebtStatDTO(String debtName, double amount) {
        this.debtName = debtName;
        this.amount = amount;
    }

    public String getDebtName() {
        return debtName;
    }

    public void setDebtName(String debtName) {
        this.debtName = debtName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
