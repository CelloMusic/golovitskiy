package com.TuzMS.GoloTask;

public class CorrectRecord {
	//Данный класс переделывае запись числа в форму, необходимую для типа float
	
	public double Rewrite(String fStr) {
		
		if (fStr.indexOf('.') == 1) {
			fStr = fStr.substring(0, 1) + "0" + fStr.substring(1);
		}
		if (fStr.indexOf('-') == -1) {
			fStr = fStr.substring(1);
		}
		
		return Double.parseDouble(fStr);
	}
}
