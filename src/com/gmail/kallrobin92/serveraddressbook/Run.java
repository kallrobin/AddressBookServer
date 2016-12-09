package com.gmail.kallrobin92.serveraddressbook;

/**
 * Created by Robin Gk on 2016-12-02 as a school project.
 * email kallrobin92@gmail.com
 */
public class Run {
    public static void main(String[] args) {
        System.out.println("Server start");
        new Thread(() -> {
            while (true) {
                new Server(61616, "centralAddressBook.txt");
            }
        }).start();
        new Thread(() -> {
            while (true) {
                new Server(60606, "centralAddressBook2.txt");
            }
        }).start();
        System.out.println("Server end");
    }
}
