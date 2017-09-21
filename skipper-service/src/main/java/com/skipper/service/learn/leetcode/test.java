package com.skipper.service.learn.leetcode;

import java.util.Scanner;

/**
 * Created by shoujian on 2017/7/23.
 */
public class test {

    public static void main(String[] args) {
        // add this year's payment and interest
        // read inputs
        Scanner in = new Scanner(System.in);

        System.out.println("How much money do you need to retire?");
        double goal = in.nextDouble();

        System.out.println("How much money will contribute every year? ");
        double payMoney = in.nextDouble();

        System.out.println("Interest rate in % :");
        double interestRate = in.nextDouble();

        double balance = 0;
        int years = 0;

        // update account balance while goal isn't reached
        while (balance < goal) {
            balance += payMoney;
            double interest = balance * interestRate / 100;
            balance += interest;
            years++;
        }
        System.out.println("You can retire in " + years + " years.");
    }

}
