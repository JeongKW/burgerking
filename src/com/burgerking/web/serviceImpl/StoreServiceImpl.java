package com.burgerking.web.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.burgerking.web.service.StoreService;

public class StoreServiceImpl implements StoreService {
	private Map<String, String> menuMap;
	private Map<String, String> orderMap;
	public StoreServiceImpl() {
		menuMap = new HashMap<>();
		orderMap = new HashMap<>();
	}
	@Override
	public void createMenu(String[] dummy) {
		for(String n : dummy) {
			String arr[] = n.split("/");
			menuMap.put(arr[0], arr[1]);
		}
	}
	@Override
	public void orderMenu(String menu) {
		String arr[] = menu.split("/");
		orderMap.put(arr[0], arr[1]);
	}
	@Override
	public int paymentMenu() {
		int resInt = 0;
//		Iterator<String> iter = orderMap.keySet().iterator();
//		while(iter.hasNext()) {
//			String key = (String)iter.next();
//			resInt += Integer.parseInt(menuMap.get(key)) 
//					  * Integer.parseInt(orderMap.get(key));
//		}
		Set<String> keys = orderMap.keySet();
		for(String n : keys) {
			resInt += Integer.parseInt(menuMap.get(n))
					  * Integer.parseInt(orderMap.get(n));
		}
		return resInt;
	}
	@Override
	public String confirmPayment(String money) {
		String res = "";
		
		int moneyInt = Integer.parseInt(money), price = paymentMenu(), resInt = 0;
		resInt = moneyInt - price;
		if(resInt > 0) {
			res = "고객님, 잔돈 " + resInt + "원 여기있습니다";
		} else {
			res = "고객님, 돈이 " + (-resInt) + "원 모자릅니다";
		}
		return res;
	}
	@Override
	public String viewPriceMenu() {
		String res = "";
		res += new SimpleDateFormat("[yyyy-MM-dd hh:mm:ss]\n")
							.format(new Date());
		int resInt = 0;
		Set<String> keys = orderMap.keySet();
		for(String n : keys) {
			res += String.format("[품목] %s [수량] %s [가격] %d\n", n, 
					orderMap.get(n), Integer.parseInt(menuMap.get(n))
					  * Integer.parseInt(orderMap.get(n)));
			resInt += Integer.parseInt(menuMap.get(n))
					  * Integer.parseInt(orderMap.get(n));
		}
		res += "[총 가격] " + resInt + "입니다.";
		return res;
	}
	
}
