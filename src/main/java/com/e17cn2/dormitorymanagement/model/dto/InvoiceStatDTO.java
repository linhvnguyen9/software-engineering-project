package com.e17cn2.dormitorymanagement.model.dto;

public class InvoiceStatDTO {
    private double monthRevenue;

    public InvoiceStatDTO(double monthRevenue) {
        this.monthRevenue = monthRevenue;
    }

    public double getMonthRevenue() {
        return monthRevenue;
    }

    public void setMonthRevenue(double monthRevenue) {
        this.monthRevenue = monthRevenue;
    }
}
