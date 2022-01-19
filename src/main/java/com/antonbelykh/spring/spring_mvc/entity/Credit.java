package com.antonbelykh.spring.spring_mvc.entity;

import com.antonbelykh.spring.spring_mvc.validation.annotation.CheckPeriod;
import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "credit")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

//    @Min(value = 6, message = "Period of credit should be min 6 month, pls try again")
    @CheckPeriod
    @Column(name = "periodCredit")
    private double periodCredit;

    @Min(value = 500000, message = "Amount of credit should be min 500000 RUR, pls try again")
    @Column(name = "amount")
    private double amount;

    @Min(value = 5, message = "Percent of cost the credit should be min 5%, pls try again and enter param without %")
    @Column(name = "costPercentage")
    private double costPercentage;

    @Column(name = "status")
    private String status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "credit", fetch = FetchType.EAGER)
    private List<Payment> paymentList;

    public Credit() {
    }

    public Credit(int periodCredit, double amount, double costPercentage, String status) {
        this.periodCredit = periodCredit;
        this.amount = amount;
        this.costPercentage = costPercentage;
        this.status = status;
    }

    public void addPaymentToCredit(Payment payment) {
        if (paymentList == null) {
            paymentList = new ArrayList<>();
        }
        paymentList.add(payment);
        payment.setCredit(this);
        this.status = "Calculate is Done!";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPeriodCredit() {
        return periodCredit;
    }

    public void setPeriodCredit(double periodCredit) {
            this.periodCredit = periodCredit;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getCostPercentage() {
        return costPercentage;
    }

    public void setCostPercentage(double costPercentage) {
        this.costPercentage = costPercentage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }
}
