package com.TuzMS.GoloTask;

public class CorrectRecord {
	//������ ����� ����������� ������ ����� � �����, ����������� ��� ���� float
	
	public float Rewrite(String fStr) {
		
		if (fStr.indexOf('.') == 1) {
			fStr = fStr.substring(0, 1) + "0" + fStr.substring(1);
		}
		if (fStr.indexOf('-') == -1) {
			fStr = fStr.substring(1);
		}
		
		return Float.parseFloat(fStr);
	}
}
