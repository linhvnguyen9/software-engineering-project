package com.e17cn2.dormitorymanagement.model.dto;

public class InvoiceStatDto {
    private double monthRevenue;

    public InvoiceStatDto(double monthRevenue) {
        this.monthRevenue = monthRevenue;
    }

    public double getMonthRevenue() {
        return monthRevenue;
    }

    public void setMonthRevenue(double monthRevenue) {
        this.monthRevenue = monthRevenue;
    }
}
