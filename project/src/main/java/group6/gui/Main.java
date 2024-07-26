package group6.gui;

import group6.service.CustomerService;
import group6.service.ICustomerService;


public class Main {
	public static void main(String[] args) {
	    String fileName = "JPAS";
	    ICustomerService customerService = new CustomerService(fileName);
	}
}
