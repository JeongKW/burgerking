package com.burgerking.web.controller;

import javax.swing.JOptionPane;

import com.burgerking.web.contants.Constants;
import com.burgerking.web.service.StoreService;
import com.burgerking.web.serviceImpl.StoreServiceImpl;

public class StoreController {
	public static void main(String[] args) {
		StoreService storeService = new StoreServiceImpl();
		while(true) {
			switch(JOptionPane.showInputDialog(Constants.MENU)) {
			case "0":
				JOptionPane.showMessageDialog(null, Constants.CANCEL);
				return;
			case "1":
				String[] dummy = {
					"Hamburger/5000",
					"Beverage/1500",
					"Chips/2000",
					"Coffee/1000"
				};
				storeService.createMenu(dummy);
				break;
			case "2":
				JOptionPane.showMessageDialog
					(null, "주문을 하려면 확인버튼을 누르십시오");
				do {
					storeService.orderMenu(JOptionPane.showInputDialog(Constants.ORDER));
				}while((JOptionPane.showInputDialog("[0]주문완료\n[1]계속주문")).equals("1"));
				JOptionPane.showMessageDialog(null, "주문이 완료되었습니다");
				break;
			case "3":
				JOptionPane.showMessageDialog(null, storeService.viewPriceMenu());
				JOptionPane.showMessageDialog(
						null, storeService.confirmPayment(
								JOptionPane.showInputDialog("금액을 넣어주세요")));
				break;
			default:
				JOptionPane.showMessageDialog(null, "옵션 번호를 선택해주세요");
				break;
			}
		}
	}
}
