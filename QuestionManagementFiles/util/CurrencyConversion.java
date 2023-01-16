package com.revature.util;
import java.util.Scanner;

public class CurrencyConversion {
	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
	    System.out.println("Enter the Amount in USD: ");
	    int USD = a.nextInt();
	    double INR = 82.27* USD;
	    a.close();
	    System.out.println(""+USD+" USD in INR is equal to "+INR+" Rs");
	}

}
