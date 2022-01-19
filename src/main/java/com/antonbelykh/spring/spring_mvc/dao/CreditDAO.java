package com.antonbelykh.spring.spring_mvc.dao;

import com.antonbelykh.spring.spring_mvc.entity.Credit;

import java.util.List;

/**
Набор CRUD операций
@author Just1kz
 **/
public interface CreditDAO {

    public List<Credit> getAll();

    public Credit getId(int id);

    public void saveOrUpdate(Credit credit);

    public void deleteById(int id);

    void deleteScheduleAfterUpdateCreditParams(int id);
}
