package com.revature.util;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.menu.UserAuthentication;

public class CurrencyConversion {
	private static final Logger logger = Logger.getLogger(UserAuthentication.class);

	public static void main(String[] args) {
		extracted();
	}

	public static void extracted() {
		Scanner a = new Scanner(System.in);
	    logger.info("\nEnter the Amount in USD: ");
	    int USD = a.nextInt();
	    double INR = 82.27* USD;
	    a.close();
	    logger.info("\n"+USD+" USD in INR is equal to "+INR+" Rs");
	}

}
