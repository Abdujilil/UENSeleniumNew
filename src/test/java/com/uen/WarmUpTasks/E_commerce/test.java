package com.uen.WarmUpTasks.E_commerce;

import com.github.javafaker.Faker;

import java.util.Random;

public class test {

    public static void main(String[] args) {

        Random random = new Random();
        Faker faker = new Faker();
        System.out.println(faker.phoneNumber().cellPhone());

    }
}
