package com.shop.gero.exceptions;


public class NotPaymentTypeAvailable extends RuntimeException{

    public  NotPaymentTypeAvailable(String message){
        super(message);
    }
}
