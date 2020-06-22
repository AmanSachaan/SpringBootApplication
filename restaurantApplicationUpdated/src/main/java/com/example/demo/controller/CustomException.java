package com.example.demo.controller;

public class CustomException extends Exception {
    public CustomException()
    {
        super("No Access");
    }
}
