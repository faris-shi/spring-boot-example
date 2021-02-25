package com.github.faris.example.criteria;


import lombok.Data;

@Data
public class UserCriteria {

    private String email;

    private String cardNumber;

    private int maxAge;

    private int minAge;

    private String keyword;
}
