package com.gmail.kallrobin92.serveraddressbook;

/**
 * Created by Robin Gk on 2016-12-02 as a school project.
 * email kallrobin92@gmail.com
 */
public class Run {
    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                System.out.println("Server start");
                new Server(61616, "centralAddressBook.txt");
                System.out.println("Server end");
            }
        }).start();
        new Thread(() -> {
            while (true) {
                System.out.println("Server start");
                new Server(60606, "centralAddressBo ok2.txt");
                System.out.println("Server end");
            }
        }).start();
    }
}
