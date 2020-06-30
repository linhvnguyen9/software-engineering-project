package com.e17cn2.dormitorymanagement.model.dto;

public class DebtStatDto {
    private String debtName;
    private double amount;

    public DebtStatDto() {
    }

    public DebtStatDto(String debtName, double amount) {
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
