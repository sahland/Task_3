package com.sahland;

import java.util.Scanner;

public class MainCustom {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int size = 10;
        int temp = 0;

        System.out.println("Введите массив чисел: ");

        MyQueue<Integer> y = new MyQueue<>();
        MyQueue<Integer> resultSecond;

        for (int i = 0; i < size; i++) {
            temp = input.nextInt();
            y.add(temp);
        }

        System.out.println("Массив чисел до изменений: ");
        for (int i = 0; i < size; i++) {
            System.out.println(y.get(i));
        }

        System.out.println("Массив чисел после изменений: ");
        resultSecond = newQueue(y);

        for (int i = 0; i < size; i++) {
            System.out.println(resultSecond.get(i));
        }

    }

    public static MyQueue newQueue(MyQueue<Integer> in) {
        int temp = 0;

        MyQueue<Integer> out = new MyQueue<>();

        for (Integer i = 0; i < in.size(); i++) {
            temp = in.get(i);
            if (temp < 0) {
                out.add(temp);
            }
        }

        for (Integer i = 0; i < in.size(); i++) {
            temp = in.get(i);
            if (temp == 0) {
                out.add(temp);
            }
        }

        for (Integer i = 0; i < in.size(); i++) {
            temp = in.get(i);
            if (temp > 0) {
                out.add(temp);
            }
        }

        return out;
    }
}
