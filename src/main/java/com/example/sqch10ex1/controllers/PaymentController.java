package com.example.sqch10ex1.controllers;

import com.example.sqch10ex1.entities.PaymentDetails;
import com.example.sqch10ex1.exceptions.ErrorDetails;
import com.example.sqch10ex1.exceptions.NotEnoughMoneyException;
import com.example.sqch10ex1.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    private static Logger logger = Logger.getLogger(PaymentController.class.getName());

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment(){
        try {
            PaymentDetails paymentDetails = paymentService.processPayment();
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);
        }catch (NotEnoughMoneyException e){
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Not enough money");
            return ResponseEntity
                    .badRequest()
                    .body(errorDetails);
        }
    }

    @PostMapping("/paymentAdvice")
    public ResponseEntity<PaymentDetails> makePaymentAdvice(){
        PaymentDetails paymentDetails = paymentService.processPayment();
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);

    }

    @PostMapping("/paymentBody")
    public ResponseEntity<PaymentDetails> makePaymentBody(@RequestBody PaymentDetails paymentDetails){
        logger.info("Received payment "+paymentDetails.getAmount());
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);

    }

}
