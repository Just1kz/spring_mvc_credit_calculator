package com.antonbelykh.spring.spring_mvc.service;

import com.antonbelykh.spring.spring_mvc.entity.Credit;

import java.util.List;

public interface CreditService {

    public List<Credit> getAll();

    public Credit getId(int id);

    public void saveOrUpdate(Credit credit);

    public void deleteById(int id);

    public void calculateSchedulePayments(int id);

    public void deleteScheduleAfterUpdateCreditParams(int id);
}
