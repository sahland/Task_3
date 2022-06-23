package com.sahland;


import java.util.*;


public class Main {

    public static Queue newQueue(Queue<Integer> in) {

        int temp;
        Queue<Integer> out = new ArrayDeque<>();

        for (Integer i : in) {
            temp = i;
            if (temp < 0)
                out.add(temp);
        }

        for (Integer i : in) {
            temp = i;
            if (temp == 0)
                out.add(temp);
        }


        for (Integer i : in) {
            temp = i;
            if (temp > 0)
                out.add(temp);
        }

        return out;
    }

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        int size = 10;
        System.out.println("Введите очередь чисел: ");

        Queue<Integer> x = new ArrayDeque<>();
        Queue<Integer> result;

        for (int i = 0; i < size; i++) {
            x.add(input.nextInt());
        }

        System.out.println("Очередь чисел до изменений: ");
        System.out.println(x.toString());

        System.out.println("Очередь чисел после изменений: ");
        result = newQueue(x);
        System.out.println(result.toString());
    }

}