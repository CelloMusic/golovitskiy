package com.TuzMS.GoloTask;

public class Method {
	//������������ ����� ��� �������� �������
	protected double[] Xi; //�������� � �����
	protected double[] Yi; //�������� Y �����
	protected double[] a = new double[3]; //������������ ���������������� �����������
	protected int k; //��������� �����
		
	public Method(double[] x, double[] y){
		Xi = x;
		Yi = y;
		k = Xi.length;
	}
		
	protected double[] ResApproks() {
		//��������� �������������
		double[] YRes = new double[k];
		for (int j = 0; j < k; j++) {
			YRes[j] = yRes(Xi[j]);
		}
		return YRes;
	}
	
	protected double yRes(double x) {
		//��������� ������������� � ����� �
		return a[1]*x + a[2]*Math.pow(x, 3) + a[3]*Math.pow(x, 5);
	}

}
