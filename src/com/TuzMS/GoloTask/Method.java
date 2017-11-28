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
		double[] YRes = new double[k];
		for (int j = 0; j < k; j++) {
			YRes[j] = a[1]*Xi[j] + a[2]*Math.pow(Xi[j], 3)
					+ a[3]*Math.pow(Xi[j], 5);
		}
		return YRes;
	}

}
