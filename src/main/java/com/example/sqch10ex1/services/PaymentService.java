package com.example.sqch10ex1.services;

import com.example.sqch10ex1.entities.PaymentDetails;
import com.example.sqch10ex1.exceptions.NotEnoughMoneyException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment(){
        throw new NotEnoughMoneyException();
    }

}
