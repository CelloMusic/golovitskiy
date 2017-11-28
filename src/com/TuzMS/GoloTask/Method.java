package com.TuzMS.GoloTask;

public class Method {
	//������������ ����� ��� �������� �������
		private double[] Xi; //�������� � �����
		private double[] Yi; //�������� Y �����
		private double[] a = new double[3]; //������������ ���������������� �����������
		private int n; //��������� �����
		
		public Method(double[] x, double[] y){
			Xi = x;
			Yi = y;
			n = Xi.length;
		}
		
		protected double[] ResApproks() {
			double[] YRes = new double[n];
			for (int j = 0; j < n; j++) {
				YRes[j] = a[1]*Xi[j] + a[2]*Math.pow(Xi[j], 3)
						+ a[3]*Math.pow(Xi[j], 5);
			}
			return YRes;
		}

}
