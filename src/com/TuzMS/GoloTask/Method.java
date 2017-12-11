package com.TuzMS.GoloTask;

public class Method {
	//������������ ����� ��� �������� �������
	protected double[] Xi; //�������� � �����
	protected double[] Yi; //�������� Y �����
	protected double[] r; // ���
	protected double[] a = new double[3]; //������������ ���������������� �����������
	protected int k; //��������� �����
		
	public Method(double[] x, double[] y, double[] ri){
		Xi = x;
		Yi = y;
		k = Xi.length;
		r = ri;
	}
		
	/*protected double[] ResApproks() {
		//��������� �������������
		double[] YRes = new double[k];
		for (int j = 0; j < k; j++) {
			YRes[j] = yRes(Xi[j]);
		}
		return YRes;
	}*/
	
	protected double yRes(double x) {
		//��������� ������������� � ����� �
		double c = a[0]*x + a[1]*Math.pow(x, 3) + a[2]*Math.pow(x, 5);
		return c;
	}
	
	public double AbsNevyazka() {
		//���������� �������
		double p = 0;
		for (int i = 0; i < k; i++) {
			p += Math.pow(Yi[i] - yRes(Xi[i]), 2);
		}
		p = Math.sqrt(p);
		return p;
	}
	
	public double OtnNevyazka() {
		//������������� ������� � %
		double norma = 0;
		for (int i = 0; i < k; i++) {
			norma += Math.pow(Yi[i], 2);
		}
		norma = Math.sqrt(norma);
		double p = AbsNevyazka() * 100 / norma;
		return p;
	}
	
}
