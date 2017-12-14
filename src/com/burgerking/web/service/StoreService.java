package com.burgerking.web.service;


public interface StoreService {
	public void createMenu(String[] dummy);
	public void orderMenu(String menu);
	public int paymentMenu();
	public String confirmPayment(String money);
	public String viewPriceMenu();
}
