package com.coffee;

public class Demo {
    public static void main(String[] args) {
        SystemIdleTime systemIdleTime = new SystemIdleTime();
        while (true) {
            System.out.println(String.format("idle time: %s", systemIdleTime.getSystemIdleTime()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
