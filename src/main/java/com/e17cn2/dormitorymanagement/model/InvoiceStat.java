package com.e17cn2.dormitorymanagement.model;

public class InvoiceStat {
    private double monthRevenue;

    public InvoiceStat(double monthRevenue) {
        this.monthRevenue = monthRevenue;
    }

    public double getMonthRevenue() {
        return monthRevenue;
    }

    public void setMonthRevenue(double monthRevenue) {
        this.monthRevenue = monthRevenue;
    }
}
