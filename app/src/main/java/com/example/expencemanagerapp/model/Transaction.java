package com.example.expencemanagerapp.model;

public class Transaction {
    public static final int TYPE_GET = 1;
    public static final int TYPE_PAY = 2;

    private String recentActivity;
    private String getMoney; // Null if not a "Get Money" transaction
    private String paidMoney; // Null if not a "Pay Money" transaction
    private int type; // Type of transaction (Get, Pay, or Both)

    public Transaction(String recentActivity, String getMoney, String paidMoney, int type) {
        this.recentActivity = recentActivity;
        this.getMoney = getMoney;
        this.paidMoney = paidMoney;
        this.type = type;
    }

    public String getRecentActivity() {
        return recentActivity;
    }

    public String getGetMoney() {
        return getMoney;
    }

    public String getPaidMoney() {
        return paidMoney;
    }

    public int getType() {
        return type;
    }
}
