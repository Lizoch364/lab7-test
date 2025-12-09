package com.example;

public class Calculator {

    // Метод сложения
    public int add(int a, int b) {
        return a + b;
    }

    // Метод умножения
    public int multiply(int a, int b) {
        return a * b;
    }

    // Комплексная операция для интеграционного теста
    public int processOrder(int items, int price, int discount) {
        int total = multiply(items, price);
        return add(total, -discount);
    }
}
