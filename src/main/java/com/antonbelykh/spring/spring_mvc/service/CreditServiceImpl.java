package com.antonbelykh.spring.spring_mvc.service;

import com.antonbelykh.spring.spring_mvc.dao.CreditDAO;
import com.antonbelykh.spring.spring_mvc.entity.Credit;
import com.antonbelykh.spring.spring_mvc.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    private final CreditDAO creditDAO;

    @Autowired
    public CreditServiceImpl(CreditDAO creditDAO) {
        this.creditDAO = creditDAO;
    }

    @Override
    @Transactional
    public List<Credit> getAll() {
        return creditDAO.getAll();
    }

    @Override
    @Transactional
    public Credit getId(int id) {
        return creditDAO.getId(id);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Credit credit) {
        creditDAO.saveOrUpdate(credit);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        creditDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void calculateSchedulePayments(int id) {
        Credit credit = getId(id);
        List<Payment> schedulePayment = new ArrayList<>();
        Payment payment;
        double annuityPayment = calculateAnnuityPayment(credit);
        double everyMonthPercentRatio = credit.getCostPercentage()/100/12;

        for (int i = 0; i < credit.getPeriodCredit(); i++) {
            payment = new Payment();
            payment.setPayment(annuityPayment);

            if (i==0) {
                payment.setDebtBeforePayment(credit.getAmount());
            } else {
                int count = i -1;
                payment.setDebtBeforePayment(schedulePayment.get(count).getDebtAfterPayment());
            }
            payment.setMonth(i+1);
            payment.setPercentPayment(payment.getDebtBeforePayment() * everyMonthPercentRatio);
            payment.setDebtPayment(payment.getPayment() - payment.getPercentPayment());
            payment.setDebtAfterPayment(payment.getDebtBeforePayment() - payment.getDebtPayment());
            schedulePayment.add(payment);
        }

        for (Payment rsl:schedulePayment) {
            credit.addPaymentToCredit(rsl);
        }

        creditDAO.saveOrUpdate(credit);
    }

    @Override
    @Transactional
    public void deleteScheduleAfterUpdateCreditParams(int id) {
        creditDAO.deleteScheduleAfterUpdateCreditParams(id);
    }

    private double calculateAnnuityPayment(Credit credit) {
        double amount = credit.getAmount();
        double period = credit.getPeriodCredit();
        double everyMonthPercentRatio = credit.getCostPercentage()/100/12;
        return amount * (everyMonthPercentRatio + everyMonthPercentRatio/(Math.pow((1+everyMonthPercentRatio), period) - 1));
    }
}
