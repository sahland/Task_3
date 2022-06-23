package com.sahland;

import java.util.ArrayDeque;
import java.util.Queue;

public class Logic {

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
}
